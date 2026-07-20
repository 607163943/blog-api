package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 文章返回视图对象
 */
@ApiModel(description = "文章返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
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
     * 文章分类名
     */
    @ApiModelProperty("文章分类名")
    private String categoryName;
    /**
     * 文章简介
     */
    @ApiModelProperty("文章简介")
    private String articleSummary;
    /**
     * 文章标签名数组
     */
    @ApiModelProperty("文章标签名数组")
    private List<String> tags;
    /**
     * 文章状态
     */
    @ApiModelProperty("文章状态：[0]草稿 [1]发布")
    private Integer articleStatus;
    /**
     * 首次发布时间
     */
    @ApiModelProperty("首次发布时间")
    private LocalDateTime publishTime;
}
