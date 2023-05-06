package com.ruoyi.monitor.service;

import java.util.List;

import com.ruoyi.monitor.domain.TbAlarmRecord;


/**
 * smtp 服务配置Service接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface ITbAlarmRecordService 
{
    /**
     * 查询smtp 服务配置
     * 
     * @param id smtp 服务配置主键
     * @return smtp 服务配置
     */
    public TbAlarmRecord selectTbAlarmRecordById(Long id);

    /**
     * 查询smtp 服务配置列表
     * 
     * @param tbAlarmRecord smtp 服务配置
     * @return smtp 服务配置集合
     */
    public List<TbAlarmRecord> selectTbAlarmRecordList(TbAlarmRecord tbAlarmRecord);

    /**
     * 新增smtp 服务配置
     * 
     * @param tbAlarmRecord smtp 服务配置
     * @return 结果
     */
    public int insertTbAlarmRecord(TbAlarmRecord tbAlarmRecord);

    /**
     * 修改smtp 服务配置
     * 
     * @param tbAlarmRecord smtp 服务配置
     * @return 结果
     */
    public int updateTbAlarmRecord(TbAlarmRecord tbAlarmRecord);

    /**
     * 批量删除smtp 服务配置
     * 
     * @param ids 需要删除的smtp 服务配置主键集合
     * @return 结果
     */
    public int deleteTbAlarmRecordByIds(Long[] ids);

    /**
     * 删除smtp 服务配置信息
     * 
     * @param id smtp 服务配置主键
     * @return 结果
     */
    public int deleteTbAlarmRecordById(Long id);
}
