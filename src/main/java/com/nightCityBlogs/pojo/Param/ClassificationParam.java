package com.nightCityBlogs.pojo.Param;

import lombok.Data;
/**
 * 前端传入
 * 分类信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class ClassificationParam {
    private int id;
    private String classification;
    private String newClassification;
}
