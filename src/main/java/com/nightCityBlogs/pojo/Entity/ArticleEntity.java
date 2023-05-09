package com.nightCityBlogs.pojo.Entity;

import lombok.Data;

@Data
public class ArticleEntity {
    private int id;
    private String isTop;//是否置顶
    private String isHot;//是否热门
    private String banner;//文章图片链接
    private String pubTime;//发布时间
    private String title;//文章标题
    private String summary;//文章简介
    private int viewsCount;//观看人数
    private int commentsCount;//评论数
}
