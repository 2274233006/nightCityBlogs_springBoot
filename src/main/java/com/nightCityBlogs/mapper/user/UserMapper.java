package com.nightCityBlogs.mapper.user;

import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    //注册
    void register(String username, String password, String emailAddress);
}
