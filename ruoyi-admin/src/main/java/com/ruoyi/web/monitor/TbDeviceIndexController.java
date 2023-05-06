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
import com.ruoyi.monitor.domain.TbDeviceIndex;
import com.ruoyi.monitor.service.ITbDeviceIndexService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备监控指标Controller
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@RestController
@RequestMapping("/monitor/index")
public class TbDeviceIndexController extends BaseController
{
    @Autowired
    private ITbDeviceIndexService tbDeviceIndexService;

    /**
     * 查询设备监控指标列表
     */
    @PreAuthorize("@ss.hasPermi('system:index:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbDeviceIndex tbDeviceIndex)
    {
        startPage();
        List<TbDeviceIndex> list = tbDeviceIndexService.selectTbDeviceIndexList(tbDeviceIndex);
        return getDataTable(list);
    }

    /**
     * 导出设备监控指标列表
     */
    @PreAuthorize("@ss.hasPermi('system:index:export')")
    @Log(title = "设备监控指标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbDeviceIndex tbDeviceIndex)
    {
        List<TbDeviceIndex> list = tbDeviceIndexService.selectTbDeviceIndexList(tbDeviceIndex);
        ExcelUtil<TbDeviceIndex> util = new ExcelUtil<TbDeviceIndex>(TbDeviceIndex.class);
        util.exportExcel(response, list, "设备监控指标数据");
    }

    /**
     * 获取设备监控指标详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbDeviceIndexService.selectTbDeviceIndexById(id));
    }

    /**
     * 新增设备监控指标
     */
    @PreAuthorize("@ss.hasPermi('system:index:add')")
    @Log(title = "设备监控指标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbDeviceIndex tbDeviceIndex)
    {
        return toAjax(tbDeviceIndexService.insertTbDeviceIndex(tbDeviceIndex));
    }

    /**
     * 修改设备监控指标
     */
    @PreAuthorize("@ss.hasPermi('system:index:edit')")
    @Log(title = "设备监控指标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbDeviceIndex tbDeviceIndex)
    {
        return toAjax(tbDeviceIndexService.updateTbDeviceIndex(tbDeviceIndex));
    }

    /**
     * 删除设备监控指标
     */
    @PreAuthorize("@ss.hasPermi('system:index:remove')")
    @Log(title = "设备监控指标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbDeviceIndexService.deleteTbDeviceIndexByIds(ids));
    }
}
