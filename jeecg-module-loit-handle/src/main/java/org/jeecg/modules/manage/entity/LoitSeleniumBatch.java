package org.jeecg.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.io.Serializable;

/**
 *   批次配置表
 */
@Data
@TableName("selenium_batch")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoitSeleniumBatch implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**批次名称*/
    @Excel(name = "批次名称", width = 15)
    @ApiModelProperty(value = "批次名称")
    private String batchName;
    /**项目ID*/
    @ApiModelProperty(value = "项目ID")
    private String projectId;
    @Excel(name = "项目名称", width = 15)
    @TableField(exist = false)
    private String projectName;
    /**数据表*/
    @Excel(name = "数据表", width = 15)
    @ApiModelProperty(value = "数据表")
    private String batchTable;
    /**还款计划表*/
    @Excel(name = "还款计划表", width = 15)
    @ApiModelProperty(value = "还款计划表")
    private String batchRefund;
    /**打包压缩文件*/
    @Excel(name = "打包压缩文件", width = 15)
    @ApiModelProperty(value = "打包压缩文件")
    private String batchCompress;
    /**批次数量*/
    @Excel(name = "批次数量", width = 15)
    @ApiModelProperty(value = "批次数量")
    private String batchNum;
    /**上传日期*/
    @Excel(name = "上传日期", width = 15)
    @ApiModelProperty(value = "上传日期")
    private String batchDatatime;
    /**预处理状态*/
    @Excel(name = "预处理状态", width = 15)
    @ApiModelProperty(value = "预处理状态")
    private String batchProcessState;
    /**数据处理状态*/
    @Excel(name = "数据处理状态", width = 15)
    @ApiModelProperty(value = "数据处理状态")
    private String batchTreatmentState;
}
