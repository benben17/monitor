package com.ruoyi.monitor.mapper;

import java.util.List;
import com.ruoyi.monitor.domain.TbDeviceLoad;

/**
 * 设备列Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
public interface TbDeviceLoadMapper 
{
    /**
     * 查询设备列
     * 
     * @param id 设备列主键
     * @return 设备列
     */
    public TbDeviceLoad selectTbDeviceLoadById(Long id);

    /**
     * 查询设备列列表
     * 
     * @param tbDeviceLoad 设备列
     * @return 设备列集合
     */
    public List<TbDeviceLoad> selectTbDeviceLoadList(TbDeviceLoad tbDeviceLoad);

    /**
     * 新增设备列
     * 
     * @param tbDeviceLoad 设备列
     * @return 结果
     */
    public int insertTbDeviceLoad(TbDeviceLoad tbDeviceLoad);

    /**
     * 修改设备列
     * 
     * @param tbDeviceLoad 设备列
     * @return 结果
     */
    public int updateTbDeviceLoad(TbDeviceLoad tbDeviceLoad);

    /**
     * 删除设备列
     * 
     * @param id 设备列主键
     * @return 结果
     */
    public int deleteTbDeviceLoadById(Long id);

    /**
     * 批量删除设备列
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbDeviceLoadByIds(Long[] ids);
}
