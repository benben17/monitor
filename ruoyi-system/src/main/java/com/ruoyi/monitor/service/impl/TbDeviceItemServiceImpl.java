package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.monitor.domain.TbDeviceItem;
import com.ruoyi.monitor.mapper.TbDeviceItemMapper;
import com.ruoyi.monitor.service.ITbDeviceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 设备监控指标Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class TbDeviceItemServiceImpl implements ITbDeviceItemService
{
    @Autowired
    private TbDeviceItemMapper tbDeviceItemMapper;

    /**
     * 查询设备监控指标
     *
     * @param id 设备监控指标主键
     * @return 设备监控指标
     */
    @Override
    public TbDeviceItem selectTbDeviceItemById(Long id)
    {
        return tbDeviceItemMapper.selectTbDeviceItemById(id);
    }

    /**
     * 查询设备监控指标列表
     * 
     * @param TbDeviceItem 设备监控指标
     * @return 设备监控指标
     */
    @Override
    public List<TbDeviceItem> selectTbDeviceItemList(TbDeviceItem TbDeviceItem)
    {
        return tbDeviceItemMapper.selectTbDeviceItemList(TbDeviceItem);
    }

    /**
     * 新增设备监控指标
     * 
     * @param TbDeviceItem 设备监控指标
     * @return 结果
     */
    @Override
    public int insertTbDeviceItem(TbDeviceItem TbDeviceItem)
    {
        TbDeviceItem.setCreateTime(DateUtils.getNowDate());
        return tbDeviceItemMapper.insertTbDeviceItem(TbDeviceItem);
    }

    /**
     * 修改设备监控指标
     * 
     * @param TbDeviceItem 设备监控指标
     * @return 结果
     */
    @Override
    public int updateTbDeviceItem(TbDeviceItem TbDeviceItem)
    {
        TbDeviceItem.setUpdateTime(DateUtils.getNowDate());
        return tbDeviceItemMapper.updateTbDeviceItem(TbDeviceItem);
    }

    /**
     * 批量删除设备监控指标
     * 
     * @param ids 需要删除的设备监控指标主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceItemByIds(Long[] ids)
    {
        return tbDeviceItemMapper.deleteTbDeviceItemByIds(ids);
    }

    /**
     * 删除设备监控指标信息
     * 
     * @param id 设备监控指标主键
     * @return 结果
     */
    @Override
    public int deleteTbDeviceItemById(Long id)
    {
        return tbDeviceItemMapper.deleteTbDeviceItemById(id);
    }
}
