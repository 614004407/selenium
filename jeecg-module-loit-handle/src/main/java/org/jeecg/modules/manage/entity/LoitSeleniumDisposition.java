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
 *   配置表
 */
@Data
@TableName("selenium_disposition")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoitSeleniumDisposition implements Serializable {
    private static final long serialVersionUID = 1L;
    /**主键*/
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**字段名称*/
    @Excel(name = "字段名称", width = 15)
    @ApiModelProperty(value = "字段名称")
    private String dispositionName;
    /**字段类型*/
    @Excel(name = "字段类型", width = 15)
    @ApiModelProperty(value = "字段类型")
    private String dispositionType;
    /**字段长度*/
    @Excel(name = "字段长度", width = 15)
    @ApiModelProperty(value = "字段长度")
    private String dispositionLength;
    /**父ID*/
    @ApiModelProperty(value = "父ID")
    private String parentId;
    @Excel(name = "配置表名称", width = 15)
    @TableField(exist = false)
    private String parenName;
    /**创建时间*/
    @Excel(name = "创建时间", width = 15)
    @ApiModelProperty(value = "创建时间")
    private String createTime;
}
