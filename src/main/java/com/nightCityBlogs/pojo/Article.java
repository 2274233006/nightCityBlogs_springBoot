package com.nightCityBlogs.pojo;

import lombok.Data;

@Data
public class Article {
    private int id;
    private String articleName;//标题
    private String classify;//分类
    private String content;//文本内容
    private String creatTime;//发布时间
}
