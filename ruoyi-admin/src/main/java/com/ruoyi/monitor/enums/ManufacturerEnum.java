package com.ruoyi.monitor.enums;

// 设备厂商编号
public enum ManufacturerEnum {

    HUAWEI(2011,"HUAWEI"),
    H3C(25506,"H3C"),
    CISCO(9, "Cisco");


    private final Integer objectId;
    private final String manufacturerName;

    private ManufacturerEnum(Integer objectId, String manufacturerName){
        this.objectId = objectId;
        this.manufacturerName = manufacturerName;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }
}
