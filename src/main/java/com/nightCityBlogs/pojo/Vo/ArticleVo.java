package com.nightCityBlogs.pojo.Vo;

import lombok.Data;

@Data
public class ArticleVo {
    private int id;
    private String articleName;//标题
    private String classify;//分类
    private String content;//文本内容
    private String creatTime;//发布时间
}
