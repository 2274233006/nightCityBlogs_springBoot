package com.nightCityBlogs.service.admin.Impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.mapper.admin.AdminMapper;
import com.nightCityBlogs.mapper.user.SelectMapper;
import com.nightCityBlogs.pojo.Entity.ArticleEntity;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Param.ArticleParam;
import com.nightCityBlogs.pojo.Vo.UserVo;
import com.nightCityBlogs.service.admin.AdminService;
import com.nightCityBlogs.utils.COSUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SelectMapper selectMapper;

    @Override
    public SaResult getUser(int offSet) {
        if(StpUtil.isLogin()){
            List<UserEntity> user = adminMapper.getUser(offSet);
            int i = selectMapper.selectUserNumber();
            return SaResult.data(user).setMsg(Integer.toString(i));
        }
        return SaResult.error("token验证失效");
    }
    @Override
    public SaResult roleVerification() {
        if(StpUtil.isLogin()){
            Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
            int id = Integer.parseInt(loginIdByToken.toString());
            UserVo userVo = selectMapper.selectById(id);
            if(userVo.getRole().equals("admin")){
                return SaResult.ok();
            }
            return SaResult.error("当前用户非管理员");
        }
        return SaResult.error("token验证失败");
    }

    @Override
    public SaResult deleteUser(String username) {
        if(StpUtil.isLogin()){
            UserEntity userEntity = adminMapper.selectUserByUsername(username);
            if(userEntity != null){
                adminMapper.deleteUser(username);
                return SaResult.ok("用户删除成功！");
            }
            return SaResult.error("用户不存在").setCode(501);
        }
        return SaResult.error("token验证失效，请重新登录");
    }

    @Override
    public SaResult updateUser(UserEntity userEntity) {
        if(StpUtil.isLogin()){
            adminMapper.updateUser(userEntity.getId(),userEntity.getUserName(),userEntity.getPassword(),userEntity.getRole(),userEntity.getEmailAddress(),userEntity.getHeadPortrait(),userEntity.getAddress());
            return SaResult.ok("修改成功");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult uploadImg(MultipartFile file, String title) throws IOException {
        if (StpUtil.isLogin()) {
            ArticleEntity articleEntity = adminMapper.selectArticleByTitle(title);
            if(articleEntity!=null){
                COSUploadUtil cosUploadUtil = new COSUploadUtil();
                String url = cosUploadUtil.upLoadFile2COS(file.getSize(), title + "banner.jpg", file, "文章img");
                if(Objects.equals(url, "false"))
                    return SaResult.error("COS上传失败");
                System.out.println(url);
                Boolean aBoolean = adminMapper.uploadImg(url, title);
                if(aBoolean)
                    return SaResult.ok("上传成功！");
                else return SaResult.error("上传数据库失败");
            }
            return SaResult.error("标题重复");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult publishArticle(ArticleParam articleParam) {
        if(StpUtil.isLogin()){
            Boolean aBoolean = adminMapper.publishArticle(articleParam.getTitle(),
                    articleParam.getSummary(),
                    articleParam.getClassification(),
                    articleParam.getContents());
            if(aBoolean){
                return SaResult.ok("上传成功！");
            }
           return SaResult.error("上传数据库失败");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }
    @Override
    public SaResult updateImg(MultipartFile file, String title) throws IOException {
        if (StpUtil.isLogin()) {
            ArticleEntity articleEntity = adminMapper.selectArticleByTitle(title);
            if(articleEntity!=null){
                COSUploadUtil cosUploadUtil = new COSUploadUtil();
                String url = cosUploadUtil.upLoadFile2COS(file.getSize(), title + "banner.jpg", file, "文章img");
                if(Objects.equals(url, "false"))
                    return SaResult.error("COS上传失败");
                System.out.println(url);
                Boolean aBoolean = adminMapper.updateImg(url,title);
                if(aBoolean)
                    return SaResult.ok("上传成功！");
                else return SaResult.error("上传数据库失败");
            }
            return SaResult.error("标题重复");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult updateArticle(ArticleParam articleParam) {
        if(StpUtil.isLogin()){
            Boolean aBoolean = adminMapper.updateArticle(
                    articleParam.getId(),
                    articleParam.getTitle(),
                    articleParam.getSummary(),
                    articleParam.getClassification(),
                    articleParam.getContents());
            if(aBoolean){
                return SaResult.ok("上传成功！");
            }
            return SaResult.error("上传数据库失败");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult getArticleList(int offSet) {
        if(StpUtil.isLogin()){
            List<ArticleEntity> article = adminMapper.getArticleList(offSet);
            int i = selectMapper.selectArticleNumber();
            return SaResult.data(article).setMsg(Integer.toString(i));
        }
        return SaResult.error("token验证失效");
    }

    @Override
    public SaResult deleteArticle(String title) {
        if(StpUtil.isLogin()){
            ArticleEntity articleEntity = adminMapper.selectUserByTitle(title);
            if(articleEntity != null){
                adminMapper.deleteArticle(title);
                return SaResult.ok("用户删除成功！");
            }
            return SaResult.error("用户不存在").setCode(501);
        }
        return SaResult.error("token验证失效，请重新登录");
    }


}
