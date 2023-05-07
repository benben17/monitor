package com.ruoyi.monitor.domain;

import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备监控指标对象 tb_device_index
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Data
public class TbDeviceItem extends BaseEntity
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
    @Excel(name = "出流量")
    private Long maxBw;

    /** 公告状态（0正常 1异常） */
    @Excel(name = "公告状态", readConverterExp = "0=正常,1=异常")
    private String status;

}
