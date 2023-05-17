package com.nightCityBlogs.pojo.Vo;

import cn.dev33.satoken.stp.SaTokenInfo;
import lombok.Data;

import java.sql.Time;

/**
 * 传入前端
 * 用户信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class UserVo {
    private int id;
    private String username;//用户名
    private String role;//权限
    private String token;
    private String creatTime;//创建时间
    private String emailAddress;//邮箱地址
    private String address;//城市
    private String headPortrait;//头像url地址
    public UserVo(int id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }
    public UserVo(){}
}
