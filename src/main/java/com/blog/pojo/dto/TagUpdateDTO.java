package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改标签参数
 */
@ApiModel(description = "修改标签参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagUpdateDTO {
    /**
     * 标签ID
     */
    @ApiModelProperty(value = "标签ID", required = true)
    private Long id;
    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名", required = true)
    private String tagName;
}
