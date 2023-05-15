package com.nightCityBlogs.mapper.user;

import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Vo.UserVo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SelectMapper {

    UserEntity selectByName(String username);
    UserVo selectById(int id);

    int selectUserNumber();

    int selectArticleNumber();
}
