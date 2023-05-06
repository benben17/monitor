package com.ruoyi.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备监控指标对象 tb_device_index
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public class TbDeviceIndex extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 主机IP */
    @Excel(name = "主机IP")
    private Long deviceId;

    /** 监控指标 */
    @Excel(name = "监控指标")
    private String indexName;

    /** 入流量 */
    @Excel(name = "入流量")
    private Long netIn;

    /** 出流量 */
    @Excel(name = "出流量")
    private Long netOut;

    /** 公告状态（0正常 1异常） */
    @Excel(name = "公告状态", readConverterExp = "0=正常,1=异常")
    private String status;

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
    public void setNetIn(Long netIn) 
    {
        this.netIn = netIn;
    }

    public Long getNetIn() 
    {
        return netIn;
    }
    public void setNetOut(Long netOut) 
    {
        this.netOut = netOut;
    }

    public Long getNetOut() 
    {
        return netOut;
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
            .append("indexName", getIndexName())
            .append("netIn", getNetIn())
            .append("netOut", getNetOut())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
