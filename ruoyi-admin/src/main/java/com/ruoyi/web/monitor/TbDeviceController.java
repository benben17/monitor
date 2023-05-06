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
import com.ruoyi.monitor.domain.TbDevice;
import com.ruoyi.monitor.service.ITbDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备列Controller
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@RestController
@RequestMapping("/monitor/device")
public class TbDeviceController extends BaseController
{
    @Autowired
    private ITbDeviceService tbDeviceService;

    /**
     * 查询设备列列表
     */
//    @PreAuthorize("@ss.hasPermi('system:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbDevice tbDevice)
    {
        startPage();
        List<TbDevice> list = tbDeviceService.selectTbDeviceList(tbDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备列列表
     */
//    @PreAuthorize("@ss.hasPermi('system:device:export')")
    @Log(title = "设备列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbDevice tbDevice)
    {
        List<TbDevice> list = tbDeviceService.selectTbDeviceList(tbDevice);
        ExcelUtil<TbDevice> util = new ExcelUtil<TbDevice>(TbDevice.class);
        util.exportExcel(response, list, "设备列数据");
    }

    /**
     * 获取设备列详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbDeviceService.selectTbDeviceById(id));
    }

    /**
     * 新增设备列
     */
    @PreAuthorize("@ss.hasPermi('system:device:add')")
    @Log(title = "设备列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbDevice tbDevice)
    {
        return toAjax(tbDeviceService.insertTbDevice(tbDevice));
    }

    /**
     * 修改设备列
     */
    @PreAuthorize("@ss.hasPermi('system:device:edit')")
    @Log(title = "设备列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbDevice tbDevice)
    {
        return toAjax(tbDeviceService.updateTbDevice(tbDevice));
    }

    /**
     * 删除设备列
     */
    @PreAuthorize("@ss.hasPermi('system:device:remove')")
    @Log(title = "设备列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbDeviceService.deleteTbDeviceByIds(ids));
    }
}
