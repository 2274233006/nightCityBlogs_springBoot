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
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
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
     * @param userName
     * @return SaResult
     */
    @DeleteMapping("/deleteUser/{userName}")
    public SaResult deleteUser(@PathVariable String userName){
        return adminService.deleteUser(userName);
    }

    @PutMapping("/updateUser")
    public SaResult updateUser(@RequestBody UserEntity userEntity){
        return adminService.updateUser(userEntity);
    }
    @PostMapping("/uploadImg/{title}")
    public SaResult uploadImg(MultipartFile file, @PathVariable String title) throws Exception {
        return adminService.uploadImg(file,title);
    }
    @PostMapping("/updateImg/{title}")
    public SaResult updateImg(MultipartFile file, @PathVariable String title) throws Exception {
        return adminService.updateImg(file,title);
    }
    @PutMapping("/publishArticle")
    public SaResult publishArticle(@RequestBody ArticleParam articleParam){
        return adminService.publishArticle(articleParam);
    }
    @PutMapping("/updateArticle")
    public SaResult updateArticle(@RequestBody ArticleParam articleParam){
        return adminService.updateArticle(articleParam);
    }
    @GetMapping("/getArticleList/{offset}")
    public SaResult getArticleList(@PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return adminService.getArticleList(offSet);
    }

    @DeleteMapping("/deleteArticle/{title}")
    public SaResult deleteArticle(@PathVariable String title){
        return adminService.deleteArticle(title);
    }

}
