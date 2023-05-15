package com.nightCityBlogs.service.admin;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Param.ArticleParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdminService {
    SaResult getUser(int offSet);

    SaResult roleVerification();

    SaResult deleteUser(String username);

    SaResult updateUser(UserEntity userEntity);

    SaResult uploadImg(MultipartFile file, String title) throws IOException;

    SaResult publishArticle(ArticleParam articleParam);

    SaResult getArticleList(int offSet);

    SaResult deleteArticle(String title);

    SaResult updateImg(MultipartFile file, String title) throws IOException;

    SaResult updateArticle(ArticleParam articleParam);
}
