package com.ruoyi.service;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 获取设备信息
 *
 * @author zengLingYao
 * @date 2021/12/02
 */
@Service
public class SnmpService {
    /**
     * 获取系统基本信息
     */
    public final static String SYS_DESC = "1.3.6.1.2.1.1.1";
    /**
     * 获取机器名
     */
    public final static String SYS_NAME = "1.3.6.1.2.1.1.5";
    /**
     * 监控时间
     */
    public final static String SYS_UPTIME = "1.3.6.1.2.1.1.3";

    public static void main(String[] args) {
        try {
            System.out.println("基本信息:"+getMessageByIpAndOid("192.168.1.94",SYS_DESC));
            System.out.println("获取机器名:"+getMessageByIpAndOid("192.168.1.94",SYS_NAME));
            System.out.println("监控时间:"+getMessageByIpAndOid("192.168.1.94",SYS_UPTIME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMessageByIpAndOid(String ip, String oid) throws Exception{
        String variableString = "";
        try{
            //设定CommunityTarget
            CommunityTarget myTarget = new CommunityTarget();
            //机器的地址
            Address address = GenericAddress.parse("udp:"+ip+"/161");
            //设定地址
            myTarget.setAddress(address);
            //设置snmp共同体
            myTarget.setCommunity(new OctetString("public"));
            //设置超时重试次数
            myTarget.setRetries(2);
            //设置超时的时间
            myTarget.setTimeout(5*60);
            //设置使用的snmp版本
            myTarget.setVersion(SnmpConstants.version2c);
            //设定采取的协议
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
            //输出
            if(response != null){
                //通过应答pdu获得mib信息（之前绑定的OID的值），方法：VaribleBinding get(int index)
                VariableBinding vb = response.get(0);
                System.out.println(vb);
                variableString = String.valueOf(vb.getVariable());
                //调用close()方法释放该进程
                transport.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return variableString;
    }
}