package com.ruoyi.monitor.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.monitor.mapper.TbSmtpConfMapper;
import com.ruoyi.monitor.domain.TbSmtpConf;
import com.ruoyi.monitor.service.ITbSmtpConfService;

/**
 * smtp 服务配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Service
public class TbSmtpConfServiceImpl implements ITbSmtpConfService 
{
    @Autowired
    private TbSmtpConfMapper tbSmtpConfMapper;

    /**
     * 查询smtp 服务配置
     * 
     * @param id smtp 服务配置主键
     * @return smtp 服务配置
     */
    @Override
    public TbSmtpConf selectTbSmtpConfById(Long id)
    {
        return tbSmtpConfMapper.selectTbSmtpConfById(id);
    }

    /**
     * 查询smtp 服务配置列表
     * 
     * @param tbSmtpConf smtp 服务配置
     * @return smtp 服务配置
     */
    @Override
    public List<TbSmtpConf> selectTbSmtpConfList(TbSmtpConf tbSmtpConf)
    {
        return tbSmtpConfMapper.selectTbSmtpConfList(tbSmtpConf);
    }

    /**
     * 新增smtp 服务配置
     * 
     * @param tbSmtpConf smtp 服务配置
     * @return 结果
     */
    @Override
    public int insertTbSmtpConf(TbSmtpConf tbSmtpConf)
    {
        tbSmtpConf.setCreateTime(DateUtils.getNowDate());
        return tbSmtpConfMapper.insertTbSmtpConf(tbSmtpConf);
    }

    /**
     * 修改smtp 服务配置
     * 
     * @param tbSmtpConf smtp 服务配置
     * @return 结果
     */
    @Override
    public int updateTbSmtpConf(TbSmtpConf tbSmtpConf)
    {
        tbSmtpConf.setUpdateTime(DateUtils.getNowDate());
        return tbSmtpConfMapper.updateTbSmtpConf(tbSmtpConf);
    }

    /**
     * 批量删除smtp 服务配置
     * 
     * @param ids 需要删除的smtp 服务配置主键
     * @return 结果
     */
    @Override
    public int deleteTbSmtpConfByIds(Long[] ids)
    {
        return tbSmtpConfMapper.deleteTbSmtpConfByIds(ids);
    }

    /**
     * 删除smtp 服务配置信息
     * 
     * @param id smtp 服务配置主键
     * @return 结果
     */
    @Override
    public int deleteTbSmtpConfById(Long id)
    {
        return tbSmtpConfMapper.deleteTbSmtpConfById(id);
    }
}
