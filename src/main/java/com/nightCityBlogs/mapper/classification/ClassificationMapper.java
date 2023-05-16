package com.nightCityBlogs.mapper.classification;

import com.nightCityBlogs.pojo.Entity.ClassificationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationMapper {

    List<ClassificationEntity> getAll(int offset);

    Boolean updateClassification(int id, String classification, String newClassification);

    Boolean updateArticleClassification(String classification, String newClassification);

    Boolean selectArticeByClassification(String classification);

    Boolean deleteClassification(String id);

    Boolean addClassification(String classification);

    int selectUserNumber();

    List<ClassificationEntity> getAll();
}
