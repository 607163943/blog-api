package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改文章参数
 */
@ApiModel(description = "修改文章参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleUpdateDTO {
    /**
     * 文章ID
     */
    @ApiModelProperty(value = "文章ID", required = true)
    private Long id;
    /**
     * 文章标题
     */
    @ApiModelProperty("文章标题")
    private String articleTitle;
    /**
     * 文章分类ID
     */
    @ApiModelProperty("文章分类ID")
    private Long categoryId;
    /**
     * 文章标签ID数组
     */
    @ApiModelProperty("文章标签ID数组")
    private Long[] tagIds;
    /**
     * 文章封面
     */
    @ApiModelProperty("文章封面")
    private String articleCover;
    /**
     * 文章简介
     */
    @ApiModelProperty("文章简介")
    private String articleSummary;
    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    private String articleContent;
    /**
     * 文章状态：[0]草稿 [1]发布
     */
    @ApiModelProperty("文章状态：[0]草稿 [1]发布")
    private Integer articleStatus;
}
