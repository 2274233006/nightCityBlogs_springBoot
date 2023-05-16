package com.nightCityBlogs.service.article;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;

import java.util.List;

public interface ArticleService {
    List<ArticleEntity> getArticleAll();

    ArticleEntity getArticle(String id);

    SaResult getCategorizedItems(String classify);

    SaResult addViewsCount(int i);

    SaResult getFocusArticle();
}
