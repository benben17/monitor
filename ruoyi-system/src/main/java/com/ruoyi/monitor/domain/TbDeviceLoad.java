package com.ruoyi.monitor.domain;

import lombok.Data;
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
@Data
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

}
