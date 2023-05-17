package com.nightCityBlogs.pojo.Param;

import lombok.Data;
/**
 * 前端传入
 * 文章信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class ArticleParam {
    private int id;
    private String title;//标题
    private String summary;//简介
    private String contents;//内容
    private String classification;//分类
    private String isFocus;//是否为焦点
}
