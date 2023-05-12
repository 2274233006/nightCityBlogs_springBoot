package com.nightCityBlogs.service.admin.Impl;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.mapper.admin.AdminMapper;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public SaResult getUser() {
        List<UserEntity> user = adminMapper.getUser();
        return SaResult.data(user);
    }
}
