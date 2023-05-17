package com.nightCityBlogs.pojo.Entity;

import lombok.Data;
import lombok.ToString;

/**
 * 分类信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
@ToString
public class ClassificationEntity {
    private int id;
    private String classification;
    private String creatTime;
    private String updateTime;
}
