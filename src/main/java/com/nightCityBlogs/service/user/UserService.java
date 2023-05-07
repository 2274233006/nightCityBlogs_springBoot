package com.nightCityBlogs.service.user;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Param.LoginParam;
import com.nightCityBlogs.pojo.Param.RegisterParam;

public interface UserService {

    SaResult login(String username, LoginParam userParam);
    SaResult register(RegisterParam registerParam);
    SaResult logOut();

    Boolean tokenVerify();

    SaResult getRole();


}
