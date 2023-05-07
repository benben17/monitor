package com.ruoyi.monitor.domain;

import lombok.Data;
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
@Data
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

}
