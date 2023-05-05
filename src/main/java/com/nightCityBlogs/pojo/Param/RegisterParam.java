package com.nightCityBlogs.pojo.Param;

import lombok.Data;

@Data
public class RegisterParam {
    private String username;
    private String password;
    private String emailAddress;
    private String authCode;
}
