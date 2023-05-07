package com.nightCityBlogs.controller.user;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.utils.SendMaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 邮件接口
 *
 * @author nightCity
 * @version 1.0
 */
@RestController
    @RequestMapping("/mail")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class MailController {
    @Autowired
    private SendMaliService sendMaliService;

    /**
     * 已注册用户获取验证码
     *
     * @param emailAddress 邮箱
     * @return SaResult
     */
    @PostMapping("/userSendTextMail/{emailAddress}")
    public SaResult userSendTextMail(@PathVariable String emailAddress) {
        return sendMaliService.userSendTextMail(emailAddress);
    }

    /**
     * 未注册用户获取验证码
     *
     * @param emailAddress 邮箱
     * @return SaResult
     */
    @PostMapping("/sendTextMail/{emailAddress}")
    public SaResult sendTextMail(@PathVariable String emailAddress) {
        return sendMaliService.sendTextMail(emailAddress);
    }
}

