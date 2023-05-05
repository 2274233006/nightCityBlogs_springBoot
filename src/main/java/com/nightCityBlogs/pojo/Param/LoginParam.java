package com.nightCityBlogs.pojo.Param;

import lombok.Data;

/**
 * 接收前端登录数据的实体类
 */
@Data
public class LoginParam {
    private String username;
    private String password;
}
