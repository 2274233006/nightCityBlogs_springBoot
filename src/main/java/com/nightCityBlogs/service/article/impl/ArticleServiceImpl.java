package com.nightCityBlogs.service.article.impl;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.mapper.article.ArticleMapper;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import com.nightCityBlogs.service.article.ArticleService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    @Override
    public SaResult getCategorizedItems(String classify) {
       List<ArticleEntity> CategorizedItems = articleMapper.getCategorizedItems(classify);
        return SaResult.data(CategorizedItems);
    }

    @Override
    public SaResult addViewsCount(int i) {
        Boolean b = articleMapper.addViewsCount(i);
        if(b){
            return SaResult.ok();
        }
        else return SaResult.error();
    }

    @Override
    public SaResult getFocusArticle() {
       List<ArticleEntity> focusArticle = articleMapper.getFocusArticle();
       return SaResult.data(focusArticle);
    }
}
