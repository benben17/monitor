package com.ruoyi.web.monitor;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
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
import com.ruoyi.monitor.domain.TbAlarmRecord;
import com.ruoyi.monitor.service.ITbAlarmRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * smtp 服务配置Controller
 * 
 * @author ruoyi
 * @date 2023-05-06
 */
@Api("报警信息")
@RestController
@RequestMapping("/monitor/alarm/record")
public class TbAlarmRecordController extends BaseController
{
    @Autowired
    private ITbAlarmRecordService tbAlarmRecordService;

    /**
     * 查询smtp 服务配置列表
     */
//    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbAlarmRecord tbAlarmRecord)
    {
        startPage();
        List<TbAlarmRecord> list = tbAlarmRecordService.selectTbAlarmRecordList(tbAlarmRecord);
        return getDataTable(list);
    }

    /**
     * 导出smtp 服务配置列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbAlarmRecord tbAlarmRecord)
    {
        List<TbAlarmRecord> list = tbAlarmRecordService.selectTbAlarmRecordList(tbAlarmRecord);
        ExcelUtil<TbAlarmRecord> util = new ExcelUtil<TbAlarmRecord>(TbAlarmRecord.class);
        util.exportExcel(response, list, "smtp 服务配置数据");
    }

    /**
     * 获取smtp 服务配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbAlarmRecordService.selectTbAlarmRecordById(id));
    }

    /**
     * 新增smtp 服务配置
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbAlarmRecord tbAlarmRecord)
    {
        return toAjax(tbAlarmRecordService.insertTbAlarmRecord(tbAlarmRecord));
    }

    /**
     * 修改smtp 服务配置
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbAlarmRecord tbAlarmRecord)
    {
        return toAjax(tbAlarmRecordService.updateTbAlarmRecord(tbAlarmRecord));
    }

    /**
     * 删除smtp 服务配置
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "smtp 服务配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbAlarmRecordService.deleteTbAlarmRecordByIds(ids));
    }
}
