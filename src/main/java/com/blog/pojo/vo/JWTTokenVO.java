package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JWT令牌返回视图对象
 */
@ApiModel(description = "JWT令牌返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTTokenVO {
    /**
     * token名称
     */
    @ApiModelProperty("token名称")
    private String tokenName;
    /**
     * token值
     */
    @ApiModelProperty("token值")
    private String tokenValue;
}
