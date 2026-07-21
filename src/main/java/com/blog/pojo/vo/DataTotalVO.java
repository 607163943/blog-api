package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 数据统计返回视图对象
 */
@ApiModel(description = "数据统计返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataTotalVO {
    /**
     * 文章总数
     */
    @ApiModelProperty("文章总数")
    private Long articleTotal;
    /**
     * 分类总数
     */
    @ApiModelProperty("分类总数")
    private Long categoryTotal;
    /**
     * 标签总数
     */
    @ApiModelProperty("标签总数")
    private Long tagTotal;
}
