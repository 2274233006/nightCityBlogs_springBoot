package com.nightCityBlogs.pojo.Param;

import lombok.Data;
/**
 * 前端传入
 * 修改用户信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class UpdateParam {
    private String username;
    private String address;
    private String emailAddress;
    private String authCode;//验证码
    private String newEmail;
    private String newPassword;
    private String password;
}
