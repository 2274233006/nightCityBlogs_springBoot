package com.nightCityBlogs.mapper;

import com.nightCityBlogs.pojo.Article;
import com.nightCityBlogs.pojo.UserEntity;
import com.nightCityBlogs.pojo.UserVo;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    UserEntity selectByName(String username);
    UserVo selectById(int id);
    void updateItem(String username,String address,int id);
    void updateAddress(String address,int id);
}
