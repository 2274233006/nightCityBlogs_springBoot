package com.nightCityBlogs.mapper;

import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    UserEntity selectByName(String username);
    UserVo selectById(int id);
    void updateItem(String username,String address,int id);
    void updateAddress(String address,int id);

    void updateEmail(int id, String newEmail);

    void register(String username, String password, String emailAddress);

    void uploadImg(String url,int id);
}
