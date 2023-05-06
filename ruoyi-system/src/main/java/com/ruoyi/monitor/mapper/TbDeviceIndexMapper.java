package com.ruoyi.monitor.mapper;

import java.util.List;
import com.ruoyi.monitor.domain.TbDeviceIndex;

/**
 * 设备监控指标Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface TbDeviceIndexMapper 
{
    /**
     * 查询设备监控指标
     * 
     * @param id 设备监控指标主键
     * @return 设备监控指标
     */
    public TbDeviceIndex selectTbDeviceIndexById(Long id);

    /**
     * 查询设备监控指标列表
     * 
     * @param tbDeviceIndex 设备监控指标
     * @return 设备监控指标集合
     */
    public List<TbDeviceIndex> selectTbDeviceIndexList(TbDeviceIndex tbDeviceIndex);

    /**
     * 新增设备监控指标
     * 
     * @param tbDeviceIndex 设备监控指标
     * @return 结果
     */
    public int insertTbDeviceIndex(TbDeviceIndex tbDeviceIndex);

    /**
     * 修改设备监控指标
     * 
     * @param tbDeviceIndex 设备监控指标
     * @return 结果
     */
    public int updateTbDeviceIndex(TbDeviceIndex tbDeviceIndex);

    /**
     * 删除设备监控指标
     * 
     * @param id 设备监控指标主键
     * @return 结果
     */
    public int deleteTbDeviceIndexById(Long id);

    /**
     * 批量删除设备监控指标
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbDeviceIndexByIds(Long[] ids);
}