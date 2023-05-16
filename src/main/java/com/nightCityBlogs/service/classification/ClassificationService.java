package com.nightCityBlogs.service.classification;

import cn.dev33.satoken.util.SaResult;

public interface ClassificationService {
    SaResult getAll(int offset);

    SaResult updateClassification(int id, String classification, String newClassification);

    SaResult deleteClassification(String id);

    SaResult addClassification(String classification);

    SaResult getAll();
}
