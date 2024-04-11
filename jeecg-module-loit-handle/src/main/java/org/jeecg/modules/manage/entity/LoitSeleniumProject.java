package org.jeecg.modules.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 *   项目配置表
 */
@Data
@TableName("selenium_project")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoitSeleniumProject implements Serializable {
    private static final long serialVersionUID = 1L;

    /**主键*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**项目名称*/
    @Excel(name = "项目名称", width = 15)
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    /**项目来源*/
    @Excel(name = "项目来源", width = 15)
    @ApiModelProperty(value = "项目来源")
    private String projectSource;
    /**文件夹类型*/
    @Excel(name = "文件夹类型", width = 15)
    @ApiModelProperty(value = "文件夹类型")
    private String fileType;
    /**项目根目录*/
    @Excel(name = "项目根目录", width = 15)
    @ApiModelProperty(value = "项目根目录")
    private String projectCatalogue;
    /**项目描述*/
    @Excel(name = "项目描述", width = 15)
    @ApiModelProperty(value = "项目描述")
    private String projectDescription;
    /**项目状态*/
    @ApiModelProperty(value = "项目状态")
    private String projectState;
}
