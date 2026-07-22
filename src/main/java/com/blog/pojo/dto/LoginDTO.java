package com.blog.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户登录请求DTO
 */
@ApiModel(description = "用户登录请求参数")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    /**
     * 验证码缓存key
     */
    @ApiModelProperty(value = "验证码缓存key", required = true)
    private String captchaKey;
    /**
     * 验证码
     */
    @ApiModelProperty(value = "验证码", required = true)
    private String captchaCode;
}
