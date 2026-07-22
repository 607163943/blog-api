package com.blog.controller;

import com.blog.pojo.dto.LoginDTO;
import com.blog.pojo.vo.CaptchaVO;
import com.blog.pojo.vo.JWTTokenVO;
import com.blog.pojo.vo.LoginVO;
import com.blog.pojo.vo.UserProfileVO;
import com.blog.result.Result;
import com.blog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 用户登录
     *
     * @param dto 登录请求参数
     * @return JWT令牌和用户信息
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Object> login(@RequestBody LoginDTO dto) {
        try {
            JWTTokenVO token = userService.login(dto.getUsername(), dto.getPassword(), dto.getCaptchaKey(), dto.getCaptchaCode());
            UserProfileVO userProfile = userService.getUserProfile(dto.getUsername());
            LoginVO loginVO = new LoginVO(token, userProfile);
            return Result.success(loginVO);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 获取验证码
     *
     * @param captchaKey 验证码缓存key（可选）
     * @return 验证码图片Base64值和缓存key
     */
    @ApiOperation("获取验证码")
    @GetMapping("/captcha")
    public Result<CaptchaVO> captcha(@RequestParam(required = false) String captchaKey) {
        CaptchaVO data = userService.getCaptcha(captchaKey);
        return Result.success(data);
    }
}
