package com.ruoyi.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * smtp 服务配置对象 tb_alarm_record
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public class TbAlarmRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long deviceId;

    /** 监控指标 */
    @Excel(name = "监控指标")
    private String indexName;

    /** 报警内容 */
    @Excel(name = "报警内容")
    private String alarmContent;

    /** 报警级别 */
    @Excel(name = "报警级别")
    private String alarmLevel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setIndexName(String indexName) 
    {
        this.indexName = indexName;
    }

    public String getIndexName() 
    {
        return indexName;
    }
    public void setAlarmContent(String alarmContent) 
    {
        this.alarmContent = alarmContent;
    }

    public String getAlarmContent() 
    {
        return alarmContent;
    }
    public void setAlarmLevel(String alarmLevel) 
    {
        this.alarmLevel = alarmLevel;
    }

    public String getAlarmLevel() 
    {
        return alarmLevel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("indexName", getIndexName())
            .append("alarmContent", getAlarmContent())
            .append("alarmLevel", getAlarmLevel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
