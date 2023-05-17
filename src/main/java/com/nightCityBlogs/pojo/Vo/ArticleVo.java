package com.nightCityBlogs.pojo.Vo;

import lombok.Data;
/**
 * 传入前端
 * 文章信息实体类
 * @version 1.0
 * @author NightCity
 */
@Data
public class ArticleVo {
    private int id;
    private String articleName;//标题
    private String classify;//分类
    private String content;//文本内容
    private String creatTime;//发布时间
}
