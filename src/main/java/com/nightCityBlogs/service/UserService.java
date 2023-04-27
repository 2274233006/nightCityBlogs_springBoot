package com.nightCityBlogs.service;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Article;
import com.nightCityBlogs.pojo.LoginParam;
import com.nightCityBlogs.pojo.UpdateItem;

public interface UserService {
    /**
     *
     * @param username 用户名
     * @param userParam 登录信息实体类
     * @return SaResult 返回信息封装
     */
    SaResult selectByName(String username, LoginParam userParam);

    SaResult logOut();

    Boolean tokenVerify();

    SaResult updateItem(UpdateItem updateItem);


    SaResult getRole();
}
