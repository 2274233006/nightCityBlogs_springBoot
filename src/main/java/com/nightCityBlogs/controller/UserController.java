package com.nightCityBlogs.controller;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.LoginParam;
import com.nightCityBlogs.pojo.UpdateItem;
import com.nightCityBlogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * login方法
     * @param loginParam 登录信息实体类
     * @return SaResult
     */
    @PostMapping("/login")
    public SaResult selectByName(@RequestBody LoginParam loginParam){
        return userService.selectByName(loginParam.getUsername(), loginParam);
    }

    /**
     *退出登录
     * @return SaResult
     */
    @PostMapping("logout")
    public SaResult LogOut(){
        return userService.logOut();
    }
    /**
     * 修改头像，通过MultipartFile接受图像文件，存储在服务器中，在mysql中存储url地址
     * @param file
     * @return
     */
    @PostMapping("/uploadImg")
    public SaResult uploadImg(MultipartFile file){
        String originalFilename = file.getContentType();
        System.out.println(originalFilename);
        return null;
    }

    /**
     * token验证接口，token有效为true
     * @return
     */
    @PostMapping("/verify")
    public boolean tokenVerify(){
        return userService.tokenVerify();
    }

    /**
     * 修改城市数据
     * @param
     * @return
     */
    @PutMapping("/updateItem")
    public SaResult updateItem(@RequestBody UpdateItem updateItem){
        return userService.updateItem(updateItem);
    }

    @PostMapping("/role")
    public SaResult getRole(){
        return userService.getRole();
    }
}