package com.nightCityBlogs.mapper.user;

import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UpdateMapper {

    void updateItem(String username,String address,int id);
    void updateAddress(String address,int id);

    void updateEmail(int id, String newEmail);

    void uploadImg(String url,int id);

    void updatePassword(String newPassword, int id);
}
