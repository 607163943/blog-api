package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 文章分页查询参数
 */
@ApiModel(description = "文章分页查询参数")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePageDTO extends BasePageDTO {
    /**
     * 文章标题（模糊匹配）
     */
    @ApiModelProperty("文章标题（模糊匹配）")
    private String articleTitle;
    /**
     * 文章分类ID
     */
    @ApiModelProperty("文章分类ID")
    private Long categoryId;
    /**
     * 标签ID（通过文章-标签中间表关联）
     */
    @ApiModelProperty("标签ID")
    private Long tagId;

    /**
     * 文章状态（0-草稿，1-发布）
     */
    @ApiModelProperty("文章状态（0-草稿，1-发布）")
    private Integer articleStatus;
}
