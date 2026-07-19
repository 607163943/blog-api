package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 分类返回视图对象
 */
@ApiModel(description = "分类返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO {
    /**
     * id
     */
    @ApiModelProperty("分类ID")
    private Long id;
    /**
     * 分类名
     */
    @ApiModelProperty("分类名")
    private String categoryName;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
}
