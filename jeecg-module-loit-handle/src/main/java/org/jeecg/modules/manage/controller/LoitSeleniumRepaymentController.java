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
import org.jeecg.modules.manage.entity.LoitSeleniumRepayment;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.manage.service.LoitSeleniumRepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags="还款计划配置表")
@RequestMapping("/project/loitSeleniumRepayment")
@Slf4j
public class LoitSeleniumRepaymentController  extends JeecgController<LoitSeleniumRepayment, LoitSeleniumRepaymentService> {
    @Autowired
    private LoitSeleniumRepaymentService loitSeleniumRepaymentService;
    /**
     * 分页列表查询
     */
    @ApiOperation(value="还款计划配置表-分页列表查询", notes="还款计划配置表-分页列表查询")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<IPage<LoitSeleniumRepayment>> queryPageList(LoitSeleniumRepayment loitSeleniumRepayment,
                                                            @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                                            @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                                            HttpServletRequest req) {
        QueryWrapper<LoitSeleniumRepayment> queryWrapper = QueryGenerator.initQueryWrapper(loitSeleniumRepayment, req.getParameterMap());
        Page<LoitSeleniumRepayment> page = new Page<LoitSeleniumRepayment>(pageNo, pageSize);
        IPage<LoitSeleniumRepayment> pageList = loitSeleniumRepaymentService.page(page, queryWrapper);
        return Result.OK(pageList);
    }
    /**
     *   添加
     */
    @ApiOperation(value="还款计划配置表-添加", notes="还款计划配置表-添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody LoitSeleniumRepayment loitSeleniumRepayment) {
        loitSeleniumRepaymentService.save(loitSeleniumRepayment);
        return Result.OK("添加成功！");
    }

    /**
     *  编辑
     */
    @ApiOperation(value="还款计划配置表-编辑", notes="还款计划配置表-编辑")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<String> edit(@RequestBody LoitSeleniumRepayment loitSeleniumRepayment) {
        loitSeleniumRepaymentService.updateById(loitSeleniumRepayment);
        return Result.OK("修改成功!");
    }

    /**
     *   删除
     */
    @ApiOperation(value="还款计划配置表-通过id删除", notes="还款计划配置表-通过id删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result<String> delete(@RequestParam(name="id",required=true) String id) {
        loitSeleniumRepaymentService.removeById(id);
        return Result.OK("删除成功!");
    }
}
