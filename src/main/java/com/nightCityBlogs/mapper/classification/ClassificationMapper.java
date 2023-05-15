package com.nightCityBlogs.mapper.classification;

import com.nightCityBlogs.pojo.Entity.ClassificationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationMapper {

    List<ClassificationEntity> getAll();
}
