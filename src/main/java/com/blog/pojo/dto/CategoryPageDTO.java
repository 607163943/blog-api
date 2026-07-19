package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 分类分页查询参数
 */
@ApiModel(description = "分类分页查询参数")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryPageDTO extends BasePageDTO {
    /**
     * 分类名（模糊匹配）
     */
    @ApiModelProperty("分类名（模糊匹配）")
    private String categoryName;
}
