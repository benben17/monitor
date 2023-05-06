package com.ruoyi.monitor.service;

import java.util.List;
import com.ruoyi.monitor.domain.TbDevice;

/**
 * 设备列Service接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface ITbDeviceService 
{
    /**
     * 查询设备列
     * 
     * @param id 设备列主键
     * @return 设备列
     */
    public TbDevice selectTbDeviceById(Long id);

    /**
     * 查询设备列列表
     * 
     * @param tbDevice 设备列
     * @return 设备列集合
     */
    public List<TbDevice> selectTbDeviceList(TbDevice tbDevice);

    /**
     * 新增设备列
     * 
     * @param tbDevice 设备列
     * @return 结果
     */
    public int insertTbDevice(TbDevice tbDevice);

    /**
     * 修改设备列
     * 
     * @param tbDevice 设备列
     * @return 结果
     */
    public int updateTbDevice(TbDevice tbDevice);

    /**
     * 批量删除设备列
     * 
     * @param ids 需要删除的设备列主键集合
     * @return 结果
     */
    public int deleteTbDeviceByIds(Long[] ids);

    /**
     * 删除设备列信息
     * 
     * @param id 设备列主键
     * @return 结果
     */
    public int deleteTbDeviceById(Long id);
}
