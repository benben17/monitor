package com.ruoyi.service;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.event.ResponseListener;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 获取设备信息
 *
 * @author zengLingYao
 * @date 2021/12/02
 */
@Service
public class SnmpService {

    public static String switch_status = ".1.3.6.1.2.1.2.2.1.8"; // 端口状态
    public final static String SYS_DESC = "1.3.6.1.2.1.1.1";

    public final static String SYS_NAME = "1.3.6.1.2.1.1.5";
    public final static String SYS_UPTIME = "1.3.6.1.2.1.1.3";

    private static String snmp_protocol = "UDP";
    private static String snmp_port = "161";
    private static  String community = "public";
    private static int DEFAULT_VERSION = SnmpConstants.version2c;
    private static int DEFAULT_TIMEOUT = 60*10;
    private static int DEFAULT_RETRY = 2;


    /**
     * 创建对象communityTarget，用于返回target
     * @return CommunityTarget
     */
    public static CommunityTarget createDefault(String ip, String community) {
        CommunityTarget myTarget = new CommunityTarget();
        Address address = GenericAddress.parse(snmp_protocol+":"+ip+"/"+snmp_port);
        myTarget.setAddress(address);
        myTarget.setCommunity(new OctetString(community));
        myTarget.setRetries(DEFAULT_RETRY);
        myTarget.setTimeout(DEFAULT_TIMEOUT);
        myTarget.setVersion(DEFAULT_VERSION);
        return myTarget;
    }

    public static String snmpGet(String ip, String oid,String community) {
        CommunityTarget myTarget = createDefault(ip, community);
        String var = "";
        try {
            TransportMapping<UdpAddress> transport = new DefaultUdpTransportMapping();
            //调用TransportMapping中的listen()方法，启动监听进程，接收消息，由于该监听进程是守护进程，最后应调用close()方法来释放该进程
            transport.listen();
            //创建SNMP对象，用于发送请求PDU
            Snmp protocol = new Snmp(transport);
            //创建请求pdu,获取mib
            PDU request = new PDU();
            //调用的add方法绑定要查询的OID
            request.add(new VariableBinding(new OID(oid)));
            //调用setType()方法来确定该pdu的类型
            request.setType(PDU.GETNEXT);
            //调用 send(PDU pdu,Target target)发送pdu，返回一个ResponseEvent对象
            ResponseEvent responseEvent = protocol.send(request, myTarget);
            //通过ResponseEvent对象来获得SNMP请求的应答pdu，方法：public PDU getResponse()
            PDU response=responseEvent.getResponse();
            if(response != null){
                System.out.println(response);
                VariableBinding vb = response.get(0);
                var =  String.valueOf(vb.getVariable());

                transport.close();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return var;

    }
    /*根据OID列表，采用异步方式一次获取多条OID数据，并且以List形式返回*/
    /**
     * 异步采集信息
     *
     * @param ip
     * @param community
     * @param oidList
     */
    public static List<String> snmpAsynGetList(String ip, String community,
                                               List<VariableBinding> oidList) {
        List<String> result = new ArrayList<>();
        Snmp snmp = null;
        try {
            DefaultUdpTransportMapping transport = new DefaultUdpTransportMapping();
            snmp = new Snmp(transport);
            snmp.listen();
            CommunityTarget target = createDefault(ip, community);
            PDU pdu = new PDU();

            pdu.addAll(oidList);

            final CountDownLatch latch = new CountDownLatch(1);
            ResponseListener listener = new ResponseListener() {
                public void onResponse(ResponseEvent event) {
                    ((Snmp) event.getSource()).cancel(event.getRequest(), this);
                    PDU response = event.getResponse();
                    if (response != null && response.getErrorStatus() ==0) {
//                        System.out.println(response);
                        for (int i = 0; i < response.size(); i++) {
                            VariableBinding vb = response.get(i);

                            result.add(vb.getVariable().toString());
                        }
                        latch.countDown();
                    }
                }
            };

            pdu.setType(PDU.GETNEXT);
            snmp.send(pdu, target, null, listener);
            boolean wait = latch.await(30, TimeUnit.SECONDS);
            snmp.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SNMP Asyn GetList Exception:" + e);
        }
        return result;

    }

    public static void main(String[] args) {
        try {
                System.out.println(snmpGet("120.53.119.141","1.3.6.1",community));
    ////            System.out.println("获取机器名:"+getInfoByOid("120.53.119.141",SYS_NAME));
    ////            System.out.println("监控时间:"+getInfoByOid("120.53.119.141",SYS_UPTIME));
            List<VariableBinding> oidList = new ArrayList<>();
            oidList.add(new VariableBinding(new OID("1.3.6.1.2")));
            oidList.add(new VariableBinding(new OID(SYS_NAME)));
//            System.out.println(snmpAsynGetList("120.53.119.141",community,oidList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}