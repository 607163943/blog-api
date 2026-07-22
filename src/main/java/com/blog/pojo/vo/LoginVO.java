package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录返回视图对象
 */
@ApiModel(description = "登录返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    /**
     * JWT令牌
     */
    @ApiModelProperty("JWT令牌")
    private JWTTokenVO token;
    /**
     * 用户信息
     */
    @ApiModelProperty("用户信息")
    private UserProfileVO userProfile;
}
