package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新增文章参数
 */
@ApiModel(description = "新增文章参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSaveDTO {
    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题", required = true)
    private String articleTitle;
    /**
     * 文章分类ID
     */
    @ApiModelProperty(value = "文章分类ID", required = true)
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
    @ApiModelProperty(value = "文章内容", required = true)
    private String articleContent;
    /**
     * 文章状态：[0]草稿 [1]发布
     */
    @ApiModelProperty(value = "文章状态：[0]草稿 [1]发布", required = true)
    private Integer articleStatus;
}
