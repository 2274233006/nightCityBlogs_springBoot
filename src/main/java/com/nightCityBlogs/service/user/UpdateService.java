package com.nightCityBlogs.service.user;

import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Param.UpdateParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UpdateService {
    SaResult updateItem(UpdateParam updateParam);

    SaResult updateEmail(UpdateParam updateParam);

    SaResult uploadImg(MultipartFile file) throws IOException;
}
