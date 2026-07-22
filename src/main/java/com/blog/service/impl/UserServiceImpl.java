package com.blog.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.mapper.UserMapper;
import com.blog.pojo.po.AdminUser;
import com.blog.pojo.vo.CaptchaVO;
import com.blog.pojo.vo.JWTTokenVO;
import com.blog.pojo.vo.UserProfileVO;
import com.blog.service.UserService;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, AdminUser> implements UserService {

    private final Cache<String, Object> captchaCache;

    @Override
    public CaptchaVO getCaptcha(String captchaKey) {
        // 若前端传参则先清除该key对应的缓存
        if (StrUtil.isNotBlank(captchaKey)) {
            captchaCache.invalidate(captchaKey);
        }

        // 使用HuTool生成验证码（线段干扰类型）
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100);
        String captchaCode = captcha.getCode();
        String captchaImgBase64 = captcha.getImageBase64();

        // 使用HuTool的UUID工具生成captchaKey
        String newCaptchaKey = IdUtil.fastUUID();

        // 将captchaKey和captchaCode作为K-V存入缓存
        captchaCache.put(newCaptchaKey, captchaCode);

        return new CaptchaVO(captchaImgBase64, newCaptchaKey);
    }

    @Override
    public JWTTokenVO login(String username, String password, String captchaKey, String captchaCode) {
        // 1. 验证验证码是否正确（忽略大小写）
        String cachedCode = (String) captchaCache.getIfPresent(captchaKey);
        // 无论是否正确，验证完毕都要删除
        captchaCache.invalidate(captchaKey);
        if (StrUtil.isBlank(cachedCode) || !cachedCode.equalsIgnoreCase(captchaCode)) {
            throw new RuntimeException("验证码错误");
        }

        // 2. 验证用户是否存在
        AdminUser user = baseMapper.selectByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        // 3. 验证密码是否正确（BCrypt加盐哈希验证）
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        // 4. Sa-Token登录
        StpUtil.login(user.getId());

        // 5. 获取JWT令牌信息
        String tokenName = StpUtil.getTokenName();
        String tokenValue = StpUtil.getTokenValue();

        return new JWTTokenVO(tokenName, tokenValue);
    }

    @Override
    public UserProfileVO getUserProfile(String username) {
        AdminUser user = baseMapper.selectByUsername(username);
        return new UserProfileVO(user.getUsername(), user.getNickname());
    }
}
