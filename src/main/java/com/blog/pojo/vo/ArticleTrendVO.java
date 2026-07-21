package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 文章新增趋势返回视图对象
 */
@ApiModel(description = "文章新增趋势返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTrendVO {
    /**
     * 月份字符串数组
     */
    @ApiModelProperty("月份字符串数组")
    private List<String> monthList;
    /**
     * 新增文章数数组（与月份数组一一对应）
     */
    @ApiModelProperty("新增文章数数组")
    private List<Long> newArticleTotalList;
}
