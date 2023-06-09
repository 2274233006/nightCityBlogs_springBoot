package com.nightCityBlogs.controller.user;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Param.LoginParam;
import com.nightCityBlogs.pojo.Param.RegisterParam;
import com.nightCityBlogs.service.user.UserService;
import com.nightCityBlogs.utils.SendMaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.DigestUtils;
/**
 * 用户操作接口
 *
 * @author nightCity
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录
     *
     * @param loginParam 登录信息：用户名，密码
     * @return SaResult
     * 根据用户名查询数据库是否存在数据，不存在则返回SaResult.error用户不存在
     * 存在则判断密码是否正确，不正确返回SaResult.error密码错误
     * 密码验证成功后返回SaResult.data(userVo)
     * userVo:
     * id，username用户名，role权限，token，creatTime创建时间，
     * emailAddress邮箱地址，address城市，headPortrait头像url地址
     */
    @PostMapping("/login")
    public SaResult login(@RequestBody LoginParam loginParam) {
        return userService.login(loginParam.getUsername(), loginParam);
    }

    /**
     * 注册用户
     *
     * @param registerParam 注册信息
     * @return SaResult
     */
    @PutMapping("/register")
    public SaResult register(@RequestBody RegisterParam registerParam) {
        return userService.register(registerParam);
    }

    /**
     * 忘记密码
     *
     * @return
     */
    @PostMapping("/forgetSendEmail/{email}/{username}")
    public SaResult forgetSendEmail(@PathVariable String email, @PathVariable String username) {
        return userService.forgetSendEmail(email, username);
    }
    @PostMapping("/forget/{authCode}/{newPassword}/{email}/{username}")
    public SaResult forget(@PathVariable String authCode, @PathVariable String newPassword, @PathVariable String email, @PathVariable String username) {
        return userService.forget(authCode, newPassword,email,username);
    }

    /**
     * 退出登录，清楚当前用户token
     *
     * @return SaResult
     */
    @PostMapping("/logout")
    public SaResult logOut() {
        return userService.logOut();
    }

    /**
     * token验证接口，token有效为true，反之为false
     *
     * @return boolean
     */
    @PostMapping("/verify")
    public boolean tokenVerify() {
        return userService.tokenVerify();
    }

    /**
     * 获取当前用户权限
     *
     * @return SaResult
     */
    @PostMapping("/role")
    public SaResult getRole() {
        return userService.getRole();
    }
}