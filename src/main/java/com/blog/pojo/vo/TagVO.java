package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 标签返回视图对象
 */
@ApiModel(description = "标签返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagVO {
    /**
     * id
     */
    @ApiModelProperty("标签ID")
    private Long id;
    /**
     * 标签名
     */
    @ApiModelProperty("标签名")
    private String tagName;
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
