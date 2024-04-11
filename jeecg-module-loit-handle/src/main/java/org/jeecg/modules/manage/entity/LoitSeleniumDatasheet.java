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
 *   数据配置表
 */
@Data
@TableName("selenium_datasheet")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoitSeleniumDatasheet implements Serializable {
    private static final long serialVersionUID = 1L;
    /**主键*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**项目表配置名称*/
    @Excel(name = "项目表配置名称", width = 15)
    @ApiModelProperty(value = "项目表配置名称")
    private String datasheetName;
    /**批次ID*/
    @ApiModelProperty(value = "批次ID")
    private String batchId;
    @Excel(name = "批次名称", width = 15)
    @TableField(exist = false)
    private String batchName;
    /**创建时间*/
    @Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
