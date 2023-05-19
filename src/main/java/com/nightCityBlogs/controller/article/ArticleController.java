package com.nightCityBlogs.controller.article;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import com.nightCityBlogs.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章相关接口
 */
@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有文章
     * @return SaResult
     */
    @GetMapping("/all/{offset}")
    private SaResult getArticleAll(@PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return articleService.getArticleAll(offSet);
    }

    /**
     * 获取对应id文章
     * @param id id
     * @return SaResult
     */
    @GetMapping("/getArticle/{id}")
    private SaResult getArticle(@PathVariable String id){
        ArticleEntity article = articleService.getArticle(id);
        return SaResult.data(article);
    }

    /**
     * 获取对应分类文章
     * @param classify 分类
     * @return SaResult
     */
    @GetMapping("/categorizedItems/{classify}/{offset}")
    public SaResult getCategorizedItems(@PathVariable String classify, @PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return articleService.getCategorizedItems(classify,offSet);
    }

    /**
     * 增加文章浏览量
     * @param id id
     * @return SaResult
     */
    @PutMapping("/addViewsCount/{id}")
    public SaResult addViewsCount(@PathVariable String id){
        int i = Integer.parseInt(id);
        return articleService.addViewsCount(i);
    }

    /**
     * 获取焦点文章
     * @return SaResult
     */
    @GetMapping("/getFocusArticle")
    public SaResult getFocusArticle(){
        return articleService.getFocusArticle();
    }

}
