package com.nightCityBlogs.controller.classification;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Param.ClassificationParam;
import com.nightCityBlogs.service.classification.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classification")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class ClassificationController {
    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/getAll/{offset}")
    public SaResult getAll(@PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return classificationService.getAll(offSet);
    }
    @GetMapping("/getAll")
    public SaResult getAll(){
        return classificationService.getAll();
    }

    @PutMapping("/updateClassification")
    public SaResult updateClassification(@RequestBody ClassificationParam classification){
        return classificationService.updateClassification(classification.getId(),classification.getClassification(),classification.getNewClassification());
    }
    @DeleteMapping("/deleteClassification/{id}")
    public SaResult deleteClassification(@PathVariable String id){
        return classificationService.deleteClassification(id);
    }
    @PostMapping("/addClassification/{classification}")
    public SaResult addClassification(@PathVariable String classification){
        return classificationService.addClassification(classification);
    }

}
