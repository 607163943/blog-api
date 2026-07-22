package com.blog.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验证码返回视图对象
 */
@ApiModel(description = "验证码返回视图对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaVO {
    /**
     * 验证码图片Base64值
     */
    @ApiModelProperty("验证码图片Base64值")
    private String captchaImgBase64;
    /**
     * 验证码缓存key
     */
    @ApiModelProperty("验证码缓存key")
    private String captchaKey;
}
