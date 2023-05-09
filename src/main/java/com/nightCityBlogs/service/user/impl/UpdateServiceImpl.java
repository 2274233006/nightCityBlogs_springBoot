package com.nightCityBlogs.service.user.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.mapper.user.DeleteMapper;
import com.nightCityBlogs.mapper.user.SelectMapper;
import com.nightCityBlogs.mapper.user.UpdateMapper;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Param.UpdateParam;
import com.nightCityBlogs.pojo.Vo.UserVo;
import com.nightCityBlogs.service.user.UpdateService;
import com.nightCityBlogs.utils.COSUploadUtil;
import com.nightCityBlogs.utils.RedisService;
import com.nightCityBlogs.utils.RespStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    private UpdateMapper updateMapper;
    @Autowired
    private SelectMapper selectMapper;
    @Autowired
    private RedisService redisService;
    @Autowired
    private DeleteMapper deleteMapper;

    @Override
    public SaResult updateItem(UpdateParam updateParam) {
        if (StpUtil.isLogin()) {
            String tokenValue = StpUtil.getTokenValue();//获取当前用户token
            Object loginIdByToken = StpUtil.getLoginIdByToken(tokenValue);//根据token获取当前用户id
            if (loginIdByToken != null) {
                int id = Integer.parseInt(loginIdByToken.toString());
                UserEntity userEntity = selectMapper.selectByName(updateParam.getUsername());
                if (userEntity == null) {
                    updateMapper.updateItem(updateParam.getUsername(), updateParam.getAddress(), id);
                    UserVo userVo = selectMapper.selectById(id);
                    userVo.setToken(tokenValue);
                    //修改信息成功 200
                    return SaResult.data(userVo).setMsg("修改信息成功");
                }
                updateMapper.updateAddress(updateParam.getAddress(), id);
                UserVo userVo = selectMapper.selectById(id);
                userVo.setToken(tokenValue);
                //userEntity为null return:用户名重复 513
                return SaResult.data(userVo).setMsg("用户名重复，城市已修改").setCode(513);
            }
            //loginIdByToken为null return:Token令牌参数异常 401
            return SaResult.error(RespStatus.TOKEN_PARAM_EXCEPTION.getMsg()).setCode(RespStatus.TOKEN_PARAM_EXCEPTION.getCode());
        }
        //isLogin为null return:授权令牌无效，请重新登陆 401
        return SaResult.error(RespStatus.INVALID_TOKEN.getMsg()).setCode(RespStatus.INVALID_TOKEN.getCode());
    }

    @Override
    public SaResult updateEmail(UpdateParam updateParam) {
        String newEmail = updateParam.getNewEmail();
        Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
        String key = loginIdByToken.toString();
        int id = Integer.parseInt(loginIdByToken.toString());
        System.out.println(redisService.getValue(key));
        if (updateParam.getAuthCode().equals(redisService.getValue(key))) {
            updateMapper.updateEmail(id, newEmail);
            UserVo userVo = selectMapper.selectById(id);
            return SaResult.data(userVo).setMsg("修改成功！");
        }
        return SaResult.error("验证码错误");
    }

    @Override
    public SaResult uploadImg(MultipartFile file) throws IOException {
        if (StpUtil.isLogin()) {
            Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
            int id = Integer.parseInt(loginIdByToken.toString());
            UserVo userVo1 = selectMapper.selectById(id);
            String username = userVo1.getUsername();
            COSUploadUtil cosUploadUtil = new COSUploadUtil();
            String url = cosUploadUtil.upLoadFile2COS(file.getSize(), username + "HeadPortrait.jpg", file, "头像");
            if(Objects.equals(url, "false"))
                return SaResult.error("COS上传失败");
            System.out.println(url);
            updateMapper.uploadImg(url,id);
            UserVo userVo = selectMapper.selectById(id);
            return SaResult.data(userVo).setMsg("上传成功！");
        }
        return SaResult.error("token验证失败，请重新登录").setCode(501);
    }

    @Override
    public SaResult updatePassword(UpdateParam updateParam) {
        if(StpUtil.isLogin()){
            Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
            int id = Integer.parseInt(loginIdByToken.toString());
            UserEntity userEntity = selectMapper.selectByName(updateParam.getUsername());
            if(userEntity.getPassword().equals(updateParam.getPassword())){
                if(redisService.getValue(loginIdByToken.toString()).equals(updateParam.getAuthCode())){
                    updateMapper.updatePassword(updateParam.getNewPassword(),id);
                    return SaResult.ok("密码修改成功！正在跳转登录页面......");
                }
                return SaResult.error("验证码错误");
            }
            return SaResult.error("密码错误");
        }
        //token验证无效
        return SaResult.error(RespStatus.INVALID_TOKEN.getMsg()).setCode(501);
    }

    @Override
    public SaResult unsubscribe(UpdateParam updateParam) {
        if(StpUtil.isLogin()){
            Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
            int id = Integer.parseInt(loginIdByToken.toString());
            UserEntity userEntity = selectMapper.selectByName(updateParam.getUsername());
            if(userEntity.getPassword().equals(updateParam.getPassword())){
                if(redisService.getValue(loginIdByToken.toString()).equals(updateParam.getAuthCode())){
                    deleteMapper.unsubscribe(id);
                    return SaResult.ok("账户以注销！");
                }
                return SaResult.error("验证码错误");
            }
            return SaResult.error("密码错误");
        }
        return SaResult.error(RespStatus.INVALID_TOKEN.getMsg()).setCode(501);
    }
}
