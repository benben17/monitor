package com.ruoyi.monitor.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备列对象 tb_device
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Data
public class TbDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备IP */
    @Excel(name = "设备IP")
    private String ip;

    /** 协议 */
    @Excel(name = "协议")
    private String protocol;

    @Excel(name = "community")
    private String community;

    @Excel(name = "版本")
    private Integer version;

    /** 用户名 */
    @Excel(name = "用户名")
    private String user;

    /** 密码 */
    @Excel(name = "密码")
    private String passwd;

    /** 端口 */
    @Excel(name = "端口")
    private Integer port;

    /** 厂家 */
    @Excel(name = "厂家")
    private String factory;

    /** 公告状态（0正常 1异常） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private String status;

}
