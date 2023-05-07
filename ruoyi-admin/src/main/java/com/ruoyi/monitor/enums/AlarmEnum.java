package com.ruoyi.monitor.enums;

public enum AlarmEnum {
    INFO(1,"INFO"),
    WARING(2,"WARING"),
    ERROR(3, "ERROR");


    private final Integer alarmId;
    private final String alarmName;


    private AlarmEnum(Integer alarmId, String alarmName) {
        this.alarmId = alarmId;
        this.alarmName = alarmName;
    }

    public Integer getAlarmId() {
        return alarmId;
    }

    public String getAlarmName() {
        return alarmName;
    }
}
