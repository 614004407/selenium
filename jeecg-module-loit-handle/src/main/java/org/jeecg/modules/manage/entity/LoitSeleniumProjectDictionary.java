package org.jeecg.modules.manage.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *   项目配置表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LoitSeleniumProjectDictionary implements Serializable {
    private static final long serialVersionUID = 1L;

    /**项目名称*/
    @ApiModelProperty(value = "项目名称")
    private String label;
    /**项目ID*/
    @ApiModelProperty(value = "项目ID")
    private String value;
}
