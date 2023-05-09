package com.nightCityBlogs.utils;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SendMaliService {
    @Autowired
    private SendMailUtil sendMailUtil;
    @Autowired
    private RedisService redisService;
    public StringBuilder getText(){
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < 6; i++)
            text.append(random.nextInt(10));
        return text;
    }

    /**
     * 以注册用户获取邮箱验证码
     * @param emailAddress 邮箱
     * @return SaResult
     */
    public SaResult userSendTextMail(String emailAddress) {
        if(StpUtil.isLogin()){
            StringBuilder text = getText();//随机6位数
            Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());//根据当前token获取id
            //key为id
            redisService.cacheValue(loginIdByToken.toString(), String.valueOf(text), 300);
            sendMailUtil.checkMail(emailAddress, "nightCityBlogs验证码", text.toString());
            sendMailUtil.sendTextMailMessage(emailAddress, "nightCityBlogs验证码", text.toString());
            return SaResult.ok("验证码已发送至邮箱，有效期五分钟，请及时查收");
        }
        return SaResult.error("token验证失败，请重新登录");
    }

    /**
     * 未注册用户获取邮箱验证码
     * @param emailAddress 邮箱
     * @return SaResult
     */
    public SaResult sendTextMail(String emailAddress){
        StringBuilder text = getText();
        redisService.cacheValue(emailAddress, String.valueOf(text), 300);
        sendMailUtil.checkMail(emailAddress, "nightCityBlogs验证码", text.toString());
        sendMailUtil.sendTextMailMessage(emailAddress, "nightCityBlogs验证码", text.toString());
        return SaResult.ok("验证码已发送至邮箱，有效期五分钟，请及时查收");
    }

    public SaResult leaveWord(String message) {
        sendMailUtil.checkMail("2274233006@qq.com", "nightCityBlogs留言", message);
        sendMailUtil.sendTextMailMessage("2274233006@qq.com", "nightCityBlogs留言", message);
        return SaResult.ok("发送成功！");
    }
}
