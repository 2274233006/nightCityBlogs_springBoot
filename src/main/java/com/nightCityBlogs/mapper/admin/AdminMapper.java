package com.nightCityBlogs.mapper.admin;

import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<UserEntity> getUser(int offset);
    UserEntity selectUserByUsername(String username);

    void deleteUser(String username);

    void updateUser(int id, String userName, String password, String role, String emailAddress, String headPortrait, String address);

    Boolean uploadImg(String url, String title);

    ArticleEntity selectArticleByTitle(String title);

    Boolean publishArticle(String title, String summary, String classification, String contents, String isFocus);

    List<ArticleEntity> getArticleList(int offSet);

    ArticleEntity selectUserByTitle(String title);

    void deleteArticle(String title);

    Boolean updateImg(String url, String title);

    Boolean updateArticle(int id, String title, String summary, String classification, String contents, String isFocus);

}
