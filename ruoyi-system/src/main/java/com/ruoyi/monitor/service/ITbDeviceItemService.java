package com.ruoyi.monitor.service;

import java.util.List;
import com.ruoyi.monitor.domain.TbDeviceItem;

/**
 * 设备监控指标Service接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface ITbDeviceItemService 
{
    /**
     * 查询设备监控指标
     * 
     * @param id 设备监控指标主键
     * @return 设备监控指标
     */
    public TbDeviceItem selectTbDeviceItemById(Long id);

    /**
     * 查询设备监控指标列表
     * 
     * @param TbDeviceItem 设备监控指标
     * @return 设备监控指标集合
     */
    public List<TbDeviceItem> selectTbDeviceItemList(TbDeviceItem TbDeviceItem);

    /**
     * 新增设备监控指标
     * 
     * @param TbDeviceItem 设备监控指标
     * @return 结果
     */
    public int insertTbDeviceItem(TbDeviceItem TbDeviceItem);

    /**
     * 修改设备监控指标
     * 
     * @param TbDeviceItem 设备监控指标
     * @return 结果
     */
    public int updateTbDeviceItem(TbDeviceItem TbDeviceItem);

    /**
     * 批量删除设备监控指标
     * 
     * @param ids 需要删除的设备监控指标主键集合
     * @return 结果
     */
    public int deleteTbDeviceItemByIds(Long[] ids);

    /**
     * 删除设备监控指标信息
     * 
     * @param id 设备监控指标主键
     * @return 结果
     */
    public int deleteTbDeviceItemById(Long id);
}
