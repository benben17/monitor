package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.monitor.mapper.TbDeviceMapper;
import com.ruoyi.monitor.domain.TbDevice;
import com.ruoyi.monitor.service.ITbDeviceService;

/**
 * 设备列Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class TbDeviceServiceImpl implements ITbDeviceService 
{
    @Autowired
    private TbDeviceMapper tbDeviceMapper;

    /**
     * 查询设备列
     * 
     * @param id 设备列主键
     * @return 设备列
     */
    @Override
    public TbDevice selectTbDeviceById(Long id)
    {
        return tbDeviceMapper.selectTbDeviceById(id);
    }

    /**
     * 查询设备列列表
     * 
     * @param tbDevice 设备列
     * @return 设备列
     */
    @Override
    public List<TbDevice> selectTbDeviceList(TbDevice tbDevice)
    {
        return tbDeviceMapper.selectTbDeviceList(tbDevice);
    }

    /**
     * 新增设备列
     * 
     * @param tbDevice 设备列
     * @return 结果
     */
    @Override
    public int insertTbDevice(TbDevice tbDevice)
    {
        tbDevice.setCreateTime(DateUtils.getNowDate());
        return tbDeviceMapper.insertTbDevice(tbDevice);
    }

    /**
     * 修改设备列
     * 
     * @param tbDevice 设备列
     * @return 结果
     */
    @Override
    public int updateTbDevice(TbDevice tbDevice)
    {
        tbDevice.setUpdateTime(DateUtils.getNowDate());
        return tbDeviceMapper.updateTbDevice(tbDevice);
    }

    /**
     * 批量删除设备列
     * 
     * @param ids 需要删除的设备列主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceByIds(Long[] ids)
    {
        return tbDeviceMapper.deleteTbDeviceByIds(ids);
    }

    /**
     * 删除设备列信息
     * 
     * @param id 设备列主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceById(Long id)
    {
        return tbDeviceMapper.deleteTbDeviceById(id);
    }
}
