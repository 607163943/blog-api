package com.blog;

import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.crypto.digest.DigestUtil;
import com.blog.mapper.UserMapper;
import com.blog.pojo.po.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 重置管理员密码测试
 * <p>
 * 旧密码使用MD5加密存储，需要更新为BCrypt加盐哈希密文。
 * 运行此测试前请先确认application-dev.yaml中数据库连接正确，
 * 并在下方 NEW_PASSWORD 常量中设置新密码。
 */
@SpringBootTest
public class ResetAdminPasswordTests {

    /**
     * 需要重置密码的管理员用户名
     */
    private static final String ADMIN_USERNAME = "admin";

    /**
     * 新密码（运行前修改为实际需要设置的密码）
     */
    private static final String NEW_PASSWORD = "admin123";

    @Resource
    private UserMapper userMapper;

    /**
     * 重置管理员密码
     * <p>
     * 使用BCrypt加盐哈希加密新密码，并更新数据库中的密文。
     */
    @Test
    void resetAdminPassword() {
        // 查询管理员用户
        AdminUser adminUser = userMapper.selectByUsername(ADMIN_USERNAME);
        if (adminUser == null) {
            System.out.println("错误：未找到用户名为 [" + ADMIN_USERNAME + "] 的管理员，请检查 ADMIN_USERNAME 常量");
            return;
        }

        // 使用BCrypt加盐哈希加密新密码
        String newPasswordMd5 = DigestUtil.md5Hex(NEW_PASSWORD);
        String bcryptHash = BCrypt.hashpw(newPasswordMd5);
        System.out.println("========================================");
        System.out.println("用户名: " + adminUser.getUsername());
        System.out.println("旧密码密文(MD5): " + adminUser.getPassword());
        System.out.println("新密码明文: " + NEW_PASSWORD);
        System.out.println("新密码md5(DigestUtil): " + newPasswordMd5);
        System.out.println("新密码密文(BCrypt): " + bcryptHash);
        System.out.println("========================================");

        // 更新密码
        adminUser.setPassword(bcryptHash);
        int rows = userMapper.updateById(adminUser);
        if (rows > 0) {
            System.out.println("√ 密码更新成功！请使用新密码登录。");
        } else {
            System.out.println("× 密码更新失败！");
        }
    }
}
