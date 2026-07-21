package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 文章详情返回视图对象
 */
@ApiModel(description = "文章详情返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVO {
    /**
     * id
     */
    @ApiModelProperty("文章ID")
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
    private List<Long> tagIds;
    /**
     * 文章首页封面
     */
    @ApiModelProperty("文章首页封面")
    private String articleCover;
    /**
     * 文章简介
     */
    @ApiModelProperty("文章简介")
    private String articleSummary;
    /**
     * 文章内容(md)
     */
    @ApiModelProperty("文章内容")
    private String articleContent;
    /**
     * 文章状态
     */
    @ApiModelProperty("文章状态：[0]草稿 [1]发布")
    private Integer articleStatus;
}
