package org.jeecg.modules.manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.manage.entity.LoitSeleniumDatasheet;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.manage.service.LoitSeleniumDatasheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags="数据配置表")
@RequestMapping("/project/loitSeleniumDatasheet")
@Slf4j
public class LoitSeleniumDatasheetController  extends JeecgController<LoitSeleniumDatasheet, LoitSeleniumDatasheetService> {
    @Autowired
    private LoitSeleniumDatasheetService loitSeleniumDatasheetService;
    /**
     * 分页列表查询
     */
    @ApiOperation(value="数据配置表-分页列表查询", notes="数据配置表-分页列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<IPage<LoitSeleniumDatasheet>> queryPageList(LoitSeleniumDatasheet loitSeleniumDatasheet,
                                                              @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                                              @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                                              HttpServletRequest req) {
        QueryWrapper<LoitSeleniumDatasheet> queryWrapper = QueryGenerator.initQueryWrapper(loitSeleniumDatasheet, req.getParameterMap());
        Page<LoitSeleniumDatasheet> page = new Page<LoitSeleniumDatasheet>(pageNo, pageSize);
        IPage<LoitSeleniumDatasheet> pageList = loitSeleniumDatasheetService.page(page, queryWrapper);
        return Result.OK(pageList);
    }
    /**
     *   添加
     */
    @ApiOperation(value="数据配置表-添加", notes="数据配置表-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody LoitSeleniumDatasheet loitSeleniumDatasheet) {
        loitSeleniumDatasheetService.save(loitSeleniumDatasheet);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     */
    @ApiOperation(value="数据配置表-编辑", notes="数据配置表-编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<String> edit(@RequestBody LoitSeleniumDatasheet loitSeleniumDatasheet) {
        loitSeleniumDatasheetService.updateById(loitSeleniumDatasheet);
        return Result.OK("修改成功!");
    }

    /**
     *   删除
     */
    @ApiOperation(value="数据配置表-通过id删除", notes="数据配置表-通过id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        loitSeleniumDatasheetService.removeById(id);
        return Result.OK("删除成功!");
    }
}
