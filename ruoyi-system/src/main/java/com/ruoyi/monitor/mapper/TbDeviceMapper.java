package com.ruoyi.monitor.mapper;

import java.util.List;
import com.ruoyi.monitor.domain.TbDevice;

/**
 * 设备列Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface TbDeviceMapper 
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
     * 删除设备列
     * 
     * @param id 设备列主键
     * @return 结果
     */
    public int deleteTbDeviceById(Long id);

    /**
     * 批量删除设备列
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbDeviceByIds(Long[] ids);
}
