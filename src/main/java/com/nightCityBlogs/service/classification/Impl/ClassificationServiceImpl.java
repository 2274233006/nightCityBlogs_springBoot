package com.nightCityBlogs.service.classification.Impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.mapper.classification.ClassificationMapper;
import com.nightCityBlogs.pojo.Entity.ClassificationEntity;
import com.nightCityBlogs.service.classification.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    private ClassificationMapper classificationMapper;

    @Override
    public SaResult getAll(int offset) {
        List<ClassificationEntity> classification = classificationMapper.getAll(offset);
        int i = classificationMapper.selectUserNumber();
        return SaResult.data(classification).setMsg(Integer.toString(i));
    }

    @Override
    public SaResult updateClassification(int id, String classification, String newClassification) {
        if (StpUtil.isLogin()) {
            Boolean aBoolean2 = classificationMapper.selectArticeByClassification(classification);
            if (aBoolean2) {
                Boolean aBoolean = classificationMapper.updateClassification(id, classification, newClassification);
                Boolean aBoolean1 = classificationMapper.updateArticleClassification(classification, newClassification);
                if (aBoolean) {
                    if (aBoolean1) {
                        return SaResult.ok("修改成功！");
                    } else return SaResult.error("分类修改成功，对应文章数据修改失败");
                }
                return SaResult.error("数据库操作失败");
            }
        } else {
            Boolean aBoolean = classificationMapper.updateClassification(id, classification, newClassification);
            if (aBoolean) {
                return SaResult.ok("修改成功！");
            }
            return SaResult.error("数据库操作失败");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult deleteClassification(String id) {
        if(StpUtil.isLogin()){
            Boolean aBoolean = classificationMapper.deleteClassification(id);
            if(aBoolean){
                return  SaResult.ok("删除成功！");
            }return SaResult.error("数据库操作失败");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult addClassification(String classification) {
        if(StpUtil.isLogin()){
            Boolean aBoolean = classificationMapper.addClassification(classification);
            if(aBoolean){
                return  SaResult.ok("添加成功！");
            }return SaResult.error("数据库操作失败");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult getAll() {
        List<ClassificationEntity> classification = classificationMapper.getAll();
        return SaResult.data(classification);
    }
}
