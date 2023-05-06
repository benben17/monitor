package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.monitor.domain.TbDeviceIndex;
import com.ruoyi.monitor.mapper.TbDeviceIndexMapper;
import com.ruoyi.monitor.service.ITbDeviceIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 设备监控指标Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class TbDeviceIndexServiceImpl implements ITbDeviceIndexService
{
    @Autowired
    private TbDeviceIndexMapper tbDeviceIndexMapper;

    /**
     * 查询设备监控指标
     *
     * @param id 设备监控指标主键
     * @return 设备监控指标
     */
    @Override
    public TbDeviceIndex selectTbDeviceIndexById(Long id)
    {
        return tbDeviceIndexMapper.selectTbDeviceIndexById(id);
    }

    /**
     * 查询设备监控指标列表
     * 
     * @param tbDeviceIndex 设备监控指标
     * @return 设备监控指标
     */
    @Override
    public List<TbDeviceIndex> selectTbDeviceIndexList(TbDeviceIndex tbDeviceIndex)
    {
        return tbDeviceIndexMapper.selectTbDeviceIndexList(tbDeviceIndex);
    }

    /**
     * 新增设备监控指标
     * 
     * @param tbDeviceIndex 设备监控指标
     * @return 结果
     */
    @Override
    public int insertTbDeviceIndex(TbDeviceIndex tbDeviceIndex)
    {
        tbDeviceIndex.setCreateTime(DateUtils.getNowDate());
        return tbDeviceIndexMapper.insertTbDeviceIndex(tbDeviceIndex);
    }

    /**
     * 修改设备监控指标
     * 
     * @param tbDeviceIndex 设备监控指标
     * @return 结果
     */
    @Override
    public int updateTbDeviceIndex(TbDeviceIndex tbDeviceIndex)
    {
        tbDeviceIndex.setUpdateTime(DateUtils.getNowDate());
        return tbDeviceIndexMapper.updateTbDeviceIndex(tbDeviceIndex);
    }

    /**
     * 批量删除设备监控指标
     * 
     * @param ids 需要删除的设备监控指标主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceIndexByIds(Long[] ids)
    {
        return tbDeviceIndexMapper.deleteTbDeviceIndexByIds(ids);
    }

    /**
     * 删除设备监控指标信息
     * 
     * @param id 设备监控指标主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceIndexById(Long id)
    {
        return tbDeviceIndexMapper.deleteTbDeviceIndexById(id);
    }
}
