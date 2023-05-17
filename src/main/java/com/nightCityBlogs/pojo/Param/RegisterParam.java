package com.nightCityBlogs.pojo.Param;

import lombok.Data;
/**
 * 前端传入
 * 注册信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class RegisterParam {
    private String username;
    private String password;
    private String emailAddress;
    private String authCode;
}
