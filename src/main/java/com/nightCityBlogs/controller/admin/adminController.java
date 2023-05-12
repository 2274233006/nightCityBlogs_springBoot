package com.nightCityBlogs.controller.admin;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class adminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/getUser")
    public SaResult getUser(){
        return adminService.getUser();
    }
}
