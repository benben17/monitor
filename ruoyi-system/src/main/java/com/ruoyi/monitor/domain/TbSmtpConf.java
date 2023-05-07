package com.ruoyi.monitor.domain;

import lombok.Data;
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
@Data
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

}
