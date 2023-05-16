package com.nightCityBlogs.pojo.Param;

import lombok.Data;

@Data
public class ArticleParam {
    private int id;
    private String title;//标题
    private String summary;//简介
    private String contents;//内容
    private String classification;//分类
    private String isFocus;//是否为焦点
}
