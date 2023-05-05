package com.nightCityBlogs.pojo.Entity;

import lombok.Data;

/**
 * user表实体类
 */
@Data/*@data注解自动创建了类的get，set和toString方法**/
public class UserEntity {
    private int id;//主键自增 唯一标识
    private String userName;//用户名，不重复
    private String password;//密码
    private String role;//权限，数据库中为枚举，{admin，user}
    private String emailAddress;//邮箱地址
    private String headPortrait;//头像URL
    private String creatTime;//创建时间
    private String updateTime;//更新时间
    private String address;//城市
}
