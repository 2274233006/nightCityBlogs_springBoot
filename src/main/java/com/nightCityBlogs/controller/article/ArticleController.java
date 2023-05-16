package com.nightCityBlogs.controller.article;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import com.nightCityBlogs.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/all")
    private SaResult getArticleAll(){
        List<ArticleEntity> article = articleService.getArticleAll();
        return SaResult.data(article);
    }
    @GetMapping("/getArticle/{id}")
    private SaResult getArticle(@PathVariable String id){
        ArticleEntity article = articleService.getArticle(id);
        return SaResult.data(article);
    }
    @GetMapping("/categorizedItems/{classify}")
    public SaResult getCategorizedItems(@PathVariable String classify){
        return articleService.getCategorizedItems(classify);
    }
    @PutMapping("/addViewsCount/{id}")
    public SaResult addViewsCount(@PathVariable String id){
        int i = Integer.parseInt(id);
        return articleService.addViewsCount(i);
    }
    @GetMapping("/getFocusArticle")
    public SaResult getFocusArticle(){
        return articleService.getFocusArticle();
    }

}
