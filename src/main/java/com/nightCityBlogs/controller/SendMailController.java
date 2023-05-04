package com.nightCityBlogs.controller;
import com.nightCityBlogs.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * 测试邮件发送
 * @author qzz
 */
@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class SendMailController {
    @Autowired
    private MailService mailService;

    /**
     *
     */
    @PostMapping("/sendTextMail/{emailAddress}")
    public void sendTextMail(@PathVariable String emailAddress){
        Random random = new Random();
        StringBuilder text= new StringBuilder();
        for (int i=0;i<6;i++)
            text.append(random.nextInt(10));
        System.out.println(text);
        mailService.checkMail(emailAddress,"nightCityBlogs验证码", text.toString());
        mailService.sendTextMailMessage(emailAddress,"nightCityBlogs验证码", text.toString());
    }
}

