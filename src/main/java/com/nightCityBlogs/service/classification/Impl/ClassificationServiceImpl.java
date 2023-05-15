package com.nightCityBlogs.service.classification.Impl;

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
    public SaResult getAll() {
       List<ClassificationEntity> classification = classificationMapper.getAll();
        return SaResult.data(classification);
    }
}
