package com.nightCityBlogs.pojo.Param;

import lombok.Data;

/**
 * 前端传入
 * 登录信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class LoginParam {
    private String username;
    private String password;
}
