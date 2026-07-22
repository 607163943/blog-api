package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.pojo.po.AdminUser;
import com.blog.pojo.vo.CaptchaVO;
import com.blog.pojo.vo.JWTTokenVO;
import com.blog.pojo.vo.UserProfileVO;

/**
 * 用户Service接口
 */
public interface UserService extends IService<AdminUser> {

    /**
     * 获取验证码
     *
     * @param captchaKey 验证码缓存key（可为null）
     * @return 验证码返回视图对象
     */
    CaptchaVO getCaptcha(String captchaKey);

    /**
     * 用户登录
     *
     * @param username    用户名
     * @param password    密码
     * @param captchaKey  验证码缓存key
     * @param captchaCode 验证码
     * @return JWT令牌
     */
    JWTTokenVO login(String username, String password, String captchaKey, String captchaCode);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息视图对象
     */
    UserProfileVO getUserProfile(String username);
}
