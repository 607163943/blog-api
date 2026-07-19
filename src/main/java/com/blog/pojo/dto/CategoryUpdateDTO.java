package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改分类参数
 */
@ApiModel(description = "修改分类参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateDTO {
    /**
     * 分类ID
     */
    @ApiModelProperty(value = "分类ID", required = true)
    private Long id;
    /**
     * 分类名
     */
    @ApiModelProperty(value = "分类名", required = true)
    private String categoryName;
}
