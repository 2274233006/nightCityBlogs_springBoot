package com.nightCityBlogs.controller.admin;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Param.ArticleParam;
import com.nightCityBlogs.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://www.nightcity.work:1080", allowCredentials = "true")
public class adminController {
    @Autowired
    private AdminService adminService;

    /**
     * 分页查询用户 每页10条
     * @param offset 偏移量，从第offset条数据开始，返回10条数据
     * @return SaResult.data(UserEntity)
     */
    @GetMapping("/getUser/{offset}")
    public SaResult getUser(@PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return adminService.getUser(offSet);
    }

    /**
     * token验证及用户身份鉴权
     * @return SaResult
     */
    @PostMapping("/verification")
    public SaResult roleVerification(){
        return adminService.roleVerification();
    }

    /**
     * 删除指定用户
     * @param userName 用户名
     * @return SaResult
     */
    @DeleteMapping("/deleteUser/{userName}")
    public SaResult deleteUser(@PathVariable String userName){
        return adminService.deleteUser(userName);
    }

    /**
     * 修改指定id用户信息
     * @param userEntity 用户信息实体类
     * @return SaResult
     */
    @PutMapping("/updateUser")
    public SaResult updateUser(@RequestBody UserEntity userEntity){
        return adminService.updateUser(userEntity);
    }

    /**
     * 上传文章图片文件
     * @param file 文件
     * @param title 对应文章标题
     * @return SaResult
     * @throws Exception IOException
     */
    @PostMapping("/uploadImg/{title}")
    public SaResult uploadImg(MultipartFile file, @PathVariable String title) throws Exception {
        return adminService.uploadImg(file,title);
    }

    /**
     * 修改文章图片
     * @param file 文件
     * @param title 标题
     * @return SaResult
     * @throws Exception IOException
     */
    @PostMapping("/updateImg/{title}")
    public SaResult updateImg(MultipartFile file, @PathVariable String title) throws Exception {
        return adminService.updateImg(file,title);
    }

    /**
     * 发布文章
     * @param articleParam 文章信息实体类
     * @return SaResult
     */
    @PutMapping("/publishArticle")
    public SaResult publishArticle(@RequestBody ArticleParam articleParam){
        return adminService.publishArticle(articleParam);
    }

    /**
     * 修改文章
     * @param articleParam 文章信息实体类
     * @return SaResult
     */
    @PutMapping("/updateArticle")
    public SaResult updateArticle(@RequestBody ArticleParam articleParam){
        return adminService.updateArticle(articleParam);
    }
    /**
     * 获取文章列表
     * @param offset 偏移量，用户分页查询
     * @return SaResult
     */
    @GetMapping("/getArticleList/{offset}")
    public SaResult getArticleList(@PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return adminService.getArticleList(offSet);
    }

    /**
     * 删除指定文章
     * @param title 文章标题
     * @return SaResult
     */
    @DeleteMapping("/deleteArticle/{title}")
    public SaResult deleteArticle(@PathVariable String title){
        return adminService.deleteArticle(title);
    }
}
