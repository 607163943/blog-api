package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改文章状态参数
 */
@ApiModel(description = "修改文章状态参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleStatusUpdateDTO {
    /**
     * 文章ID
     */
    @ApiModelProperty(value = "文章ID", required = true)
    private Long id;
    /**
     * 文章状态：[0]草稿 [1]发布
     */
    @ApiModelProperty(value = "文章状态：[0]草稿 [1]发布", required = true)
    private Integer articleStatus;
}
