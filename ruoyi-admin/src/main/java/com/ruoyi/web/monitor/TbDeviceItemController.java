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
import com.ruoyi.monitor.domain.TbDeviceItem;
import com.ruoyi.monitor.service.ITbDeviceItemService;
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
public class TbDeviceItemController extends BaseController
{
    @Autowired
    private ITbDeviceItemService TbDeviceItemService;

    /**
     * 查询设备监控指标列表
     */
    @PreAuthorize("@ss.hasPermi('system:index:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbDeviceItem TbDeviceItem)
    {
        startPage();
        List<TbDeviceItem> list = TbDeviceItemService.selectTbDeviceItemList(TbDeviceItem);
        return getDataTable(list);
    }

    /**
     * 导出设备监控指标列表
     */
    @PreAuthorize("@ss.hasPermi('system:index:export')")
    @Log(title = "设备监控指标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbDeviceItem TbDeviceItem)
    {
        List<TbDeviceItem> list = TbDeviceItemService.selectTbDeviceItemList(TbDeviceItem);
        ExcelUtil<TbDeviceItem> util = new ExcelUtil<TbDeviceItem>(TbDeviceItem.class);
        util.exportExcel(response, list, "设备监控指标数据");
    }

    /**
     * 获取设备监控指标详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:index:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(TbDeviceItemService.selectTbDeviceItemById(id));
    }

    /**
     * 新增设备监控指标
     */
    @PreAuthorize("@ss.hasPermi('system:index:add')")
    @Log(title = "设备监控指标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbDeviceItem TbDeviceItem)
    {
        return toAjax(TbDeviceItemService.insertTbDeviceItem(TbDeviceItem));
    }

    /**
     * 修改设备监控指标
     */
    @PreAuthorize("@ss.hasPermi('system:index:edit')")
    @Log(title = "设备监控指标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbDeviceItem TbDeviceItem)
    {
        return toAjax(TbDeviceItemService.updateTbDeviceItem(TbDeviceItem));
    }

    /**
     * 删除设备监控指标
     */
    @PreAuthorize("@ss.hasPermi('system:index:remove')")
    @Log(title = "设备监控指标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(TbDeviceItemService.deleteTbDeviceItemByIds(ids));
    }
}
