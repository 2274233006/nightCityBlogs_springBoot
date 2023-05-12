package com.nightCityBlogs.service.article.impl;

import com.nightCityBlogs.mapper.article.ArticleMapper;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import com.nightCityBlogs.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleEntity> getArticleAll() {
      return  articleMapper.getArticleAll();
    }

    @Override
    public ArticleEntity getArticle(String id) {
        return articleMapper.getArticle(id);
    }
}
