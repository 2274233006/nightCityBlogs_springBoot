package com.nightCityBlogs.service.article;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;

public interface ArticleService {
    SaResult getArticleAll(int offSet);

    ArticleEntity getArticle(String id);

    SaResult getCategorizedItems(String classify, int offset);

    SaResult addViewsCount(int i);

    SaResult getFocusArticle();
}
