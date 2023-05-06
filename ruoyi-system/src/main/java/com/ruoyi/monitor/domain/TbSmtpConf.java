package com.ruoyi.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * smtp 服务配置对象 tb_smtp_conf
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public class TbSmtpConf extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String smtpName;

    /** smtp主机 */
    @Excel(name = "smtp主机")
    private String smtpHost;

    /** sender */
    @Excel(name = "sender")
    private String sender;

    /** 端口 */
    @Excel(name = "端口")
    private Long port;

    /** 0关闭1 开启 */
    @Excel(name = "0关闭1 开启")
    private Long enableSsl;

    /** 用户名 */
    @Excel(name = "用户名")
    private String smtpUser;

    /** 密码 */
    @Excel(name = "密码")
    private String smtpPasswd;

    /** 状态（0正常 1异常>） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常>")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSmtpName(String smtpName) 
    {
        this.smtpName = smtpName;
    }

    public String getSmtpName() 
    {
        return smtpName;
    }
    public void setSmtpHost(String smtpHost) 
    {
        this.smtpHost = smtpHost;
    }

    public String getSmtpHost() 
    {
        return smtpHost;
    }
    public void setSender(String sender) 
    {
        this.sender = sender;
    }

    public String getSender() 
    {
        return sender;
    }
    public void setPort(Long port) 
    {
        this.port = port;
    }

    public Long getPort() 
    {
        return port;
    }
    public void setEnableSsl(Long enableSsl) 
    {
        this.enableSsl = enableSsl;
    }

    public Long getEnableSsl() 
    {
        return enableSsl;
    }
    public void setSmtpUser(String smtpUser) 
    {
        this.smtpUser = smtpUser;
    }

    public String getSmtpUser() 
    {
        return smtpUser;
    }
    public void setSmtpPasswd(String smtpPasswd) 
    {
        this.smtpPasswd = smtpPasswd;
    }

    public String getSmtpPasswd() 
    {
        return smtpPasswd;
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
            .append("smtpName", getSmtpName())
            .append("smtpHost", getSmtpHost())
            .append("sender", getSender())
            .append("port", getPort())
            .append("enableSsl", getEnableSsl())
            .append("smtpUser", getSmtpUser())
            .append("smtpPasswd", getSmtpPasswd())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
