package com.ruoyi.monitor.domain;

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

    /** 用户名 */
    @Excel(name = "用户名")
    private String user;

    /** 密码 */
    @Excel(name = "密码")
    private String passwd;

    /** 端口 */
    @Excel(name = "端口")
    private String port;

    /** 厂家 */
    @Excel(name = "厂家")
    private String factory;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setProtocol(String protocol) 
    {
        this.protocol = protocol;
    }

    public String getProtocol() 
    {
        return protocol;
    }
    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getUser() 
    {
        return user;
    }
    public void setPasswd(String passwd) 
    {
        this.passwd = passwd;
    }

    public String getPasswd() 
    {
        return passwd;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void setFactory(String factory) 
    {
        this.factory = factory;
    }

    public String getFactory() 
    {
        return factory;
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
            .append("name", getName())
            .append("ip", getIp())
            .append("protocol", getProtocol())
            .append("user", getUser())
            .append("passwd", getPasswd())
            .append("port", getPort())
            .append("factory", getFactory())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
