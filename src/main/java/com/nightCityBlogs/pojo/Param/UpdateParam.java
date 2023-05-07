package com.nightCityBlogs.pojo.Param;

import lombok.Data;

@Data
public class UpdateParam {
    private String username;
    private String address;
    private String emailAddress;
    private String authCode;//验证码
    private String newAuthCode;
    private String newEmail;
}
