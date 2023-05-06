package com.ruoyi.web.monitor;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.monitor.domain.TbSmtpConf;
import com.ruoyi.monitor.service.ITbSmtpConfService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * smtp 服务配置Controller
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@RestController
@RequestMapping("/monitor/conf")
public class TbSmtpConfController extends BaseController
{
    @Autowired
    private ITbSmtpConfService tbSmtpConfService;

    /**
     * 查询smtp 服务配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:conf:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbSmtpConf tbSmtpConf)
    {
        startPage();
        List<TbSmtpConf> list = tbSmtpConfService.selectTbSmtpConfList(tbSmtpConf);
        return getDataTable(list);
    }

    /**
     * 导出smtp 服务配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:conf:export')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbSmtpConf tbSmtpConf)
    {
        List<TbSmtpConf> list = tbSmtpConfService.selectTbSmtpConfList(tbSmtpConf);
        ExcelUtil<TbSmtpConf> util = new ExcelUtil<TbSmtpConf>(TbSmtpConf.class);
        util.exportExcel(response, list, "smtp 服务配置数据");
    }

    /**
     * 获取smtp 服务配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:conf:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbSmtpConfService.selectTbSmtpConfById(id));
    }

    /**
     * 新增smtp 服务配置
     */
    @PreAuthorize("@ss.hasPermi('system:conf:add')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbSmtpConf tbSmtpConf)
    {
        return toAjax(tbSmtpConfService.insertTbSmtpConf(tbSmtpConf));
    }

    /**
     * 修改smtp 服务配置
     */
    @PreAuthorize("@ss.hasPermi('system:conf:edit')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbSmtpConf tbSmtpConf)
    {
        return toAjax(tbSmtpConfService.updateTbSmtpConf(tbSmtpConf));
    }

    /**
     * 删除smtp 服务配置
     */
    @PreAuthorize("@ss.hasPermi('system:conf:remove')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbSmtpConfService.deleteTbSmtpConfByIds(ids));
    }
}
