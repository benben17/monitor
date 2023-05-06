package com.ruoyi.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备列对象 tb_device_load
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public class TbDeviceLoad extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 主机IP */
    @Excel(name = "主机IP")
    private String deviceId;

    /** cpu负载 */
    @Excel(name = "cpu负载")
    private String cpu;

    /** 内存负载 */
    @Excel(name = "内存负载")
    private String memory;

    /** 连接数 */
    @Excel(name = "连接数")
    private Long sessions;

    /** 1:防火墙2F5 */
    @Excel(name = "1:防火墙2F5")
    private Long deviceType;

    /** 公告状态（0正>常 1异常） */
    @Excel(name = "公告状态", readConverterExp = "0=正>常,1=异常")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setCpu(String cpu) 
    {
        this.cpu = cpu;
    }

    public String getCpu() 
    {
        return cpu;
    }
    public void setMemory(String memory) 
    {
        this.memory = memory;
    }

    public String getMemory() 
    {
        return memory;
    }
    public void setSessions(Long sessions) 
    {
        this.sessions = sessions;
    }

    public Long getSessions() 
    {
        return sessions;
    }
    public void setDeviceType(Long deviceType) 
    {
        this.deviceType = deviceType;
    }

    public Long getDeviceType() 
    {
        return deviceType;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceId", getDeviceId())
            .append("cpu", getCpu())
            .append("memory", getMemory())
            .append("sessions", getSessions())
            .append("deviceType", getDeviceType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
