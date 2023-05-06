package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.monitor.domain.TbAlarmRecord;
import com.ruoyi.monitor.mapper.TbAlarmRecordMapper;
import com.ruoyi.monitor.service.ITbAlarmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * smtp 服务配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class TbAlarmRecordServiceImpl implements ITbAlarmRecordService
{
    @Autowired
    private TbAlarmRecordMapper tbAlarmRecordMapper;

    /**
     * 查询smtp 服务配置
     *
     * @param id smtp 服务配置主键
     * @return smtp 服务配置
     */
    @Override
    public TbAlarmRecord selectTbAlarmRecordById(Long id)
    {
        return tbAlarmRecordMapper.selectTbAlarmRecordById(id);
    }

    /**
     * 查询smtp 服务配置列表
     * 
     * @param tbAlarmRecord smtp 服务配置
     * @return smtp 服务配置
     */
    @Override
    public List<TbAlarmRecord> selectTbAlarmRecordList(TbAlarmRecord tbAlarmRecord)
    {
        return tbAlarmRecordMapper.selectTbAlarmRecordList(tbAlarmRecord);
    }

    /**
     * 新增smtp 服务配置
     * 
     * @param tbAlarmRecord smtp 服务配置
     * @return 结果
     */
    @Override
    public int insertTbAlarmRecord(TbAlarmRecord tbAlarmRecord)
    {
        tbAlarmRecord.setCreateTime(DateUtils.getNowDate());
        return tbAlarmRecordMapper.insertTbAlarmRecord(tbAlarmRecord);
    }

    /**
     * 修改smtp 服务配置
     * 
     * @param tbAlarmRecord smtp 服务配置
     * @return 结果
     */
    @Override
    public int updateTbAlarmRecord(TbAlarmRecord tbAlarmRecord)
    {
        tbAlarmRecord.setUpdateTime(DateUtils.getNowDate());
        return tbAlarmRecordMapper.updateTbAlarmRecord(tbAlarmRecord);
    }

    /**
     * 批量删除smtp 服务配置
     * 
     * @param ids 需要删除的smtp 服务配置主键
     * @return 结果
     */
    @Override
    public int deleteTbAlarmRecordByIds(Long[] ids)
    {
        return tbAlarmRecordMapper.deleteTbAlarmRecordByIds(ids);
    }

    /**
     * 删除smtp 服务配置信息
     * 
     * @param id smtp 服务配置主键
     * @return 结果
     */
    @Override
    public int deleteTbAlarmRecordById(Long id)
    {
        return tbAlarmRecordMapper.deleteTbAlarmRecordById(id);
    }
}
