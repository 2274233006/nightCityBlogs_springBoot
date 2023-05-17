package com.nightCityBlogs.service.article.impl;

import cn.dev33.satoken.util.SaResult;
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
    public SaResult getArticleAll(int offSet) {
        List<ArticleEntity> articleAll = articleMapper.getArticleAll(offSet);
        int i = articleMapper.selectArticleNumber();
        return SaResult.data(articleAll).setMsg(Integer.toString(i));
    }

    @Override
    public ArticleEntity getArticle(String id) {
        return articleMapper.getArticle(id);
    }

    @Override
    public SaResult getCategorizedItems(String classify, int offset) {
        List<ArticleEntity> CategorizedItems = articleMapper.getCategorizedItems(classify,offset);
        int i = articleMapper.selectArticleClassNumber(classify);
        return SaResult.data(CategorizedItems).setMsg(Integer.toString(i));
    }

    @Override
    public SaResult addViewsCount(int i) {
        Boolean b = articleMapper.addViewsCount(i);
        if (b) {
            return SaResult.ok();
        } else return SaResult.error();
    }

    @Override
    public SaResult getFocusArticle() {
        List<ArticleEntity> focusArticle = articleMapper.getFocusArticle();
        return SaResult.data(focusArticle);
    }
}
