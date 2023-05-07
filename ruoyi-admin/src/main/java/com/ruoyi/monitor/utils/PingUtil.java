package com.ruoyi.monitor.utils;

import lombok.extern.log4j.Log4j2;

import java.net.InetAddress;

@Log4j2
public class PingUtil {

    public static boolean ping(String ipAddress){
        int timeOut = 2000;
        int maxTries = 2;
        int tries = 0;
        try {
            while (tries < maxTries) {
                boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
                if (status) {
                    return true;
                }
                tries++;
            }

        }catch (Exception e){
           log.error(e);
        }
        return false;
    }
}
