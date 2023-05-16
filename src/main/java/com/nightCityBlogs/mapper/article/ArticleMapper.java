package com.nightCityBlogs.mapper.article;

import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
     List<ArticleEntity> getArticleAll();

     ArticleEntity getArticle(String id);

     List<ArticleEntity> getCategorizedItems(String classify);

     Boolean addViewsCount(int i);

     List<ArticleEntity> getFocusArticle();
}
