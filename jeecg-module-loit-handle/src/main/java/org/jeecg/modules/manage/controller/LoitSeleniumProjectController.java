package org.jeecg.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.manage.entity.LoitSeleniumProject;
import org.jeecg.modules.manage.entity.LoitSeleniumProjectDictionary;
import org.jeecg.modules.manage.mapper.LoitSeleniumProjectMapper;
import org.jeecg.modules.manage.service.LoitSeleniumProjectService;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags="项目配置表")
@RequestMapping("/project/loitSeleniumProject")
@Slf4j
public class LoitSeleniumProjectController  extends JeecgController<LoitSeleniumProject, LoitSeleniumProjectService> {
    @Autowired
    private LoitSeleniumProjectService loitSeleniumProjectService;
    @Autowired
    private LoitSeleniumProjectMapper loitSeleniumProjectMapper;
    /**
     * 分页列表查询
     */
    @ApiOperation(value="项目配置表-分页列表查询", notes="项目配置表-分页列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<IPage<LoitSeleniumProject>> queryPageList(LoitSeleniumProject loitSeleniumProject,
                                                            @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                                            @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                                            HttpServletRequest req) {
        QueryWrapper<LoitSeleniumProject> queryWrapper = QueryGenerator.initQueryWrapper(loitSeleniumProject, req.getParameterMap());
        Page<LoitSeleniumProject> page = new Page<LoitSeleniumProject>(pageNo, pageSize);
        IPage<LoitSeleniumProject> pageList = loitSeleniumProjectService.page(page, queryWrapper);
        return Result.OK(pageList);
    }
    /**
     * 通过ID查询
     */
    @ApiOperation(value="项目配置表-通过ID查询", notes="项目配置表-通过ID查询")
    @RequestMapping(value = "/IDQuery", method = RequestMethod.POST)
    public Result<LoitSeleniumProject> queryPageList(@RequestParam(name="id") String id) {
        LoitSeleniumProject ProjectList = loitSeleniumProjectMapper.getprojectInfo(id);
        return Result.OK(ProjectList);
    }
    /**
     *   添加
     */
    @ApiOperation(value="项目配置表-添加", notes="项目配置表-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody LoitSeleniumProject loitSeleniumProject) {
        loitSeleniumProject.setProjectState(String.valueOf('0'));
        loitSeleniumProjectService.save(loitSeleniumProject);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     */
    @ApiOperation(value="项目配置表-编辑", notes="项目配置表-编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<String> edit(@RequestBody LoitSeleniumProject loitSeleniumProject) {
        loitSeleniumProjectService.updateById(loitSeleniumProject);
        return Result.OK("修改成功!");
    }

    /**
     *   删除
     */
    @ApiOperation(value="项目配置表-通过id删除", notes="项目配置表-通过id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        loitSeleniumProjectService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 项目字典表
     */
    @ApiOperation(value="项目配置表-未建立批次的项目", notes="项目配置表-未建立批次的项目")
    @RequestMapping(value = "/dictionary", method = RequestMethod.POST)
    public Result<List> queryPageList() {
        List<LoitSeleniumProjectDictionary> alarmList = loitSeleniumProjectMapper.getProject();
        return Result.OK(alarmList);
    }
}
