package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息返回视图对象
 */
@ApiModel(description = "用户信息返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileVO {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickname;
}
