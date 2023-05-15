package com.nightCityBlogs.controller.classification;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.service.classification.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classification")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class classificationController {
    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/getAll")
    public SaResult getAll(){
        return classificationService.getAll();
    }


}
