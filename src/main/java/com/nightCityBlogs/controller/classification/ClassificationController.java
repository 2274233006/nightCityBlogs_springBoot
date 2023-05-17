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

    /**
     * 获取当前分类以分页形式展示
     * @param offset 偏移量，分页查询
     * @return SaResult
     */
    @GetMapping("/getAll/{offset}")
    public SaResult getAll(@PathVariable String offset){
        int offSet = Integer.parseInt(offset);
        return classificationService.getAll(offSet);
    }
    /**
     * 获取全部当前分类
     * @return SaResult
     */
    @GetMapping("/getAll")
    public SaResult getAll(){
        return classificationService.getAll();
    }

    /**
     * 更新分类信息
     * @param classification 分类信息实体类
     * @return SaResult
     */
    @PutMapping("/updateClassification")
    public SaResult updateClassification(@RequestBody ClassificationParam classification){
        return classificationService.updateClassification(classification.getId(),classification.getClassification(),classification.getNewClassification());
    }

    /**
     * 删除指定id分类数据
     * @param id 分类id
     * @return SaResult
     */
    @DeleteMapping("/deleteClassification/{id}")
    public SaResult deleteClassification(@PathVariable String id){
        return classificationService.deleteClassification(id);
    }

    /**
     * 新增分类
     * @param classification 分类信息实体类
     * @return SaResult
     */
    @PostMapping("/addClassification/{classification}")
    public SaResult addClassification(@PathVariable String classification){
        return classificationService.addClassification(classification);
    }

}
