package com.nightCityBlogs.service.article;

import com.nightCityBlogs.pojo.Entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    List<ArticleEntity> getArticleAll();

    ArticleEntity getArticle(String id);
}
