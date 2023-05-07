package com.nightCityBlogs.controller.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.mapper.UserMapper;
import com.nightCityBlogs.pojo.Param.UpdateParam;
import com.nightCityBlogs.pojo.Vo.UserVo;
import com.nightCityBlogs.service.user.UpdateService;
import com.nightCityBlogs.utils.COSUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 数据修改接口
 *
 * @author nightCity
 * @version 1.0
 */
@RestController
@RequestMapping("/update")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class UpdateController {

    @Autowired
    private UpdateService updateService;
    @Autowired
    private UserMapper userMapper;

    /**
     * @param updateParam 前端传入的数据
     * @return SaResult
     */
    @PutMapping("/Item")
    public SaResult updateItem(@RequestBody UpdateParam updateParam) {
        return updateService.updateItem(updateParam);
    }

    /**
     * @param updateParam 前端传入的数据
     * @return SaResult
     */
    @PutMapping("/Email")
    public SaResult updateEmail(@RequestBody UpdateParam updateParam) {
        return updateService.updateEmail(updateParam);
    }

    /**
     * 修改头像，通过MultipartFile接受图像文件，存储在服务器中，在mysql中存储url地址
     *
     * @param file 前端传入的文件
     * @return SaResult
     */
    @PostMapping("/uploadImg")
    public SaResult uploadImg(MultipartFile file) throws Exception {
        return updateService.uploadImg(file);
    }
}
