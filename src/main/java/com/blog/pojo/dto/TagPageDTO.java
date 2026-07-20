package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 标签分页查询参数
 */
@ApiModel(description = "标签分页查询参数")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagPageDTO extends BasePageDTO {
    /**
     * 标签名（模糊匹配）
     */
    @ApiModelProperty("标签名（模糊匹配）")
    private String tagName;
}
