package org.jeecg.modules.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.manage.entity.LoitSeleniumBatch;
import org.jeecg.modules.manage.entity.LoitSeleniumProject;
import org.jeecg.modules.manage.mapper.LoitSeleniumBatchMapper;
import org.jeecg.modules.manage.mapper.LoitSeleniumProjectMapper;
import org.jeecg.modules.manage.service.LoitSeleniumBatchService;
import org.jeecg.modules.manage.service.LoitSeleniumProjectService;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@Api(tags="批次配置表")
@RequestMapping("/project/loitSeleniumBatch")
@Slf4j
public class LoitSeleniumBatchController  extends JeecgController<LoitSeleniumBatch, LoitSeleniumBatchService> {
    @Autowired
    private LoitSeleniumBatchService loitSeleniumBatchService;
    @Autowired
    private LoitSeleniumBatchMapper loitSeleniumBatchMapper;
    @Autowired
    private LoitSeleniumProjectService  loitSeleniumProjectService;
    /**
     * 分页列表查询
     */
    @ApiOperation(value="批次配置表-分页列表查询", notes="批次配置表-分页列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<List<LoitSeleniumBatch>> queryPageList(  @RequestParam(name="batchName", required = false) String batchName,
                                                            @RequestParam(name="projectName", required= false) String projectName,
                                                           @RequestParam(name="batchProcessState", required = false) String batchProcessState,
                                                           @RequestParam(name="batchTreatmentState", required= false) String batchTreatmentState,
                                                            @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                                            @RequestParam(name="pageSize", defaultValue="10") Integer pageSize) {
        Integer startNum = (pageNo - 1) * pageSize;
        List<LoitSeleniumBatch> BatchList = loitSeleniumBatchMapper.getBatchList(batchName,projectName,batchProcessState,batchTreatmentState,startNum,pageSize);
        return Result.OK(BatchList);
    }
    /**
     *   添加
     */
    @ApiOperation(value="批次配置表-添加", notes="批次配置表-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody LoitSeleniumBatch loitSeleniumBatch) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        loitSeleniumBatch.setBatchDatatime(formatter.format(date));
        String projectId = loitSeleniumBatch.getProjectId();
        LoitSeleniumProject loitSeleniumProject = loitSeleniumProjectService.getById(projectId);
        if (Objects.equals(loitSeleniumProject.getFileType(), "非标准文件夹")) {
            loitSeleniumBatch.setBatchProcessState(String.valueOf(1));
        }else {
            loitSeleniumBatch.setBatchProcessState(String.valueOf(0));
        }
        loitSeleniumBatch.setBatchTreatmentState(String.valueOf(0));
        loitSeleniumBatchService.save(loitSeleniumBatch);
        return Result.OK("添加成功！");

    }

    /**
     *  编辑
     */
    @ApiOperation(value="批次配置表-编辑", notes="批次配置表-编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<String> edit(@RequestBody LoitSeleniumBatch loitSeleniumBatch) {
        loitSeleniumBatchService.updateById(loitSeleniumBatch);
        return Result.OK("修改成功!");
    }

    /**
     *   删除
     */
    @ApiOperation(value="批次配置表-通过id删除", notes="批次配置表-通过id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        loitSeleniumBatchService.removeById(id);
        return Result.OK("删除成功!");
    }
}
