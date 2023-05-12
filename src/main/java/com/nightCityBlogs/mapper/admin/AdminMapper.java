package com.nightCityBlogs.mapper.admin;

import com.nightCityBlogs.pojo.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<UserEntity> getUser();

}
