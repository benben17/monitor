package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.monitor.mapper.TbDeviceLoadMapper;
import com.ruoyi.monitor.domain.TbDeviceLoad;
import com.ruoyi.monitor.service.ITbDeviceLoadService;

/**
 * 设备列Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class TbDeviceLoadServiceImpl implements ITbDeviceLoadService 
{
    @Autowired
    private TbDeviceLoadMapper tbDeviceLoadMapper;

    /**
     * 查询设备列
     * 
     * @param id 设备列主键
     * @return 设备列
     */
    @Override
    public TbDeviceLoad selectTbDeviceLoadById(Long id)
    {
        return tbDeviceLoadMapper.selectTbDeviceLoadById(id);
    }

    /**
     * 查询设备列列表
     * 
     * @param tbDeviceLoad 设备列
     * @return 设备列
     */
    @Override
    public List<TbDeviceLoad> selectTbDeviceLoadList(TbDeviceLoad tbDeviceLoad)
    {
        return tbDeviceLoadMapper.selectTbDeviceLoadList(tbDeviceLoad);
    }

    /**
     * 新增设备列
     * 
     * @param tbDeviceLoad 设备列
     * @return 结果
     */
    @Override
    public int insertTbDeviceLoad(TbDeviceLoad tbDeviceLoad)
    {
        tbDeviceLoad.setCreateTime(DateUtils.getNowDate());
        return tbDeviceLoadMapper.insertTbDeviceLoad(tbDeviceLoad);
    }

    /**
     * 修改设备列
     * 
     * @param tbDeviceLoad 设备列
     * @return 结果
     */
    @Override
    public int updateTbDeviceLoad(TbDeviceLoad tbDeviceLoad)
    {
        tbDeviceLoad.setUpdateTime(DateUtils.getNowDate());
        return tbDeviceLoadMapper.updateTbDeviceLoad(tbDeviceLoad);
    }

    /**
     * 批量删除设备列
     * 
     * @param ids 需要删除的设备列主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceLoadByIds(Long[] ids)
    {
        return tbDeviceLoadMapper.deleteTbDeviceLoadByIds(ids);
    }

    /**
     * 删除设备列信息
     * 
     * @param id 设备列主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceLoadById(Long id)
    {
        return tbDeviceLoadMapper.deleteTbDeviceLoadById(id);
    }
}
