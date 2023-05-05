package com.nightCityBlogs.service.user.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.nightCityBlogs.pojo.Entity.UserEntity;
import com.nightCityBlogs.pojo.Param.LoginParam;
import com.nightCityBlogs.pojo.Param.UpdateParam;
import com.nightCityBlogs.pojo.Vo.UserVo;
import com.nightCityBlogs.utils.RedisService;
import com.nightCityBlogs.utils.RespStatus;
import com.nightCityBlogs.mapper.UserMapper;
import com.nightCityBlogs.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisService redisService;

    /**
     * 通过username字段查询数据库user表，若查询为空则返回用户不存在
     * 反之，检测用户传入的密码与数据库的密码是否相同，
     * 相同则登录，通过sa-token生成随机128位字符串，将用户的id，权限，用户名，token返回给前端
     * 反之返回密码错误
     *
     * @param username   用户名
     * @param loginParam 登录信息
     * @return SaResult
     */
    @Override
    public SaResult selectByName(String username, LoginParam loginParam) {
        //根据username查询数据库是否存在
        UserEntity userEntity = userMapper.selectByName(username);
        //为空则存在改用户，返回error：用户不存在
        if (Objects.isNull(userEntity)) {
            return SaResult.error(RespStatus.NO_USER_EXIST.getMsg());
        }
        //反之判断用户提供的密码是否与mysql中的密码一致
        if (loginParam.getPassword().equals(userEntity.getPassword())) {
            //根据用户id返回一个token
            StpUtil.login(userEntity.getId());
            //实例化返回前端的用户信息类
            UserVo userVo = new UserVo(userEntity.getId(), userEntity.getUserName(), userEntity.getRole());
            //获取token信息
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            //赋值
            userVo.setToken(tokenInfo.tokenValue);
            userVo.setCreatTime(userEntity.getCreatTime());
            userVo.setAddress(userEntity.getAddress());
            userVo.setEmailAddress(userEntity.getEmailAddress());
            userVo.setHeadPortrait(userEntity.getHeadPortrait());
            //返回所有信息
            return SaResult.data(userVo);
        }
        //返回error：用户不存在：密码错误
        return SaResult.error(RespStatus.INVALID_PASSWORD.getMsg());
    }

    /**
     * 退出登录，前端请求头携带satoken字段，通过token注销
     *
     * @return SaResult ok&error
     */
    @Override
    public SaResult logOut() {
        if (StpUtil.isLogin()) {
            StpUtil.logout();
            return SaResult.ok("退出成功，token已清除");
        }
        return SaResult.error("token验证失败，请重新登录");
    }

    @Override
    public Boolean tokenVerify() {
        if (StpUtil.isLogin()) {
            return true;
        }
        return false;
    }

    @Override
    public SaResult updateItem(UpdateParam updateParam) {
        if (StpUtil.isLogin()) {
            String tokenValue = StpUtil.getTokenValue();//获取当前用户token
            Object loginIdByToken = StpUtil.getLoginIdByToken(tokenValue);//根据token获取当前用户id
            if (loginIdByToken != null) {
                int id = Integer.parseInt(loginIdByToken.toString());
                UserEntity userEntity = userMapper.selectByName(updateParam.getUsername());
                if (userEntity == null) {
                        userMapper.updateItem(updateParam.getUsername(), updateParam.getAddress(),id);
                    UserVo userVo = userMapper.selectById(id);
                    userVo.setToken(tokenValue);
                    //修改信息成功 200
                    return SaResult.data(userVo).setMsg("修改信息成功");
                }
                userMapper.updateAddress(updateParam.getAddress(),id);
                UserVo userVo = userMapper.selectById(id);
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
    public SaResult getRole() {
        if(StpUtil.isLogin()){
            String tokenValue = StpUtil.getTokenValue();//获取当前用户token
            Object loginIdByToken = StpUtil.getLoginIdByToken(tokenValue);//根据token获取当前用户id
            if (loginIdByToken != null) {
                int id = Integer.parseInt(loginIdByToken.toString());
                UserVo userVo = userMapper.selectById(id);
                String role = userVo.getRole();
                return SaResult.data(role);
            }
        }
        return SaResult.error(RespStatus.INVALID_TOKEN.getMsg());
    }


    @Override
    public SaResult updateEmail(UpdateParam updateParam) {
        String newEmail = updateParam.getNewEmail();
        Object loginIdByToken = StpUtil.getLoginIdByToken(StpUtil.getTokenValue());
        String key = loginIdByToken.toString();
        int id = Integer.parseInt(loginIdByToken.toString());
        System.out.println(redisService.getValue(key));
        if(updateParam.getAuthCode().equals(redisService.getValue(key))){
            userMapper.updateEmail(id,newEmail);
            UserVo userVo = userMapper.selectById(id);
            return SaResult.data(userVo).setMsg("修改成功！");
        }
        return SaResult.error("验证码错误");
    }
}
