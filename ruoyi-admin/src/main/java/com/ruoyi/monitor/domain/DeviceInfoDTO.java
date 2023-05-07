package com.ruoyi.monitor.domain;

import lombok.Data;

@Data
public class DeviceInfoDTO {
    private String manufacturer;   // 设备产商
    private String ipv4Address;             // 设备ipv4地址
    private String deviceName;              // 设备名
    private Integer portNumber;              // 端口数量
    private Long uptime;   // 设备启动时间
    private Long total; //内存总容量
    private Long free;  //内存空闲大小
    private Double memoryUsage; //内存使用率

}