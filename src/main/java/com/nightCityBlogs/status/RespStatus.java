package com.nightCityBlogs.status;

/**
 * 返回状态码信息
 *
 * @author lufeng
 * @version 1.0
 */
public enum RespStatus {

//    FAIL(1500, "ERROR"),
    FAIL(1500, "失败"),
//    SUCCESS(200, "SUCCESS"),
    SUCCESS(200, "成功"),
    LOGOUT_SUCCESS(200, "已退出登录"),
    EDIT_PWD_SUCCESS(200, "修改密码成功"),
    EDIT_ITM_SUCCESS(200, "修改信息成功"),
//    BAD_REQUEST(400, "Bad Request"),
    BAD_REQUEST(400, "错误的请求"),
//    UNAUTHORIZED(401, "Unauthorized"),
    UNAUTHORIZED(401, "未经授权"),
    INVALID_TOKEN(401, "授权令牌无效，请重新登陆"),
    TOKEN_PARAM_EXCEPTION(401, "Token令牌参数异常"),
    FORBIDDEN(403, "您没有权限访问"),
//    NOT_FOUND(404, "Not Found"),
    NOT_FOUND(404, "网页找不到了"),
//    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    METHOD_NOT_ALLOWED(405, "不允许的方法"),
 //   UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),
//    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    INTERNAL_SERVER_ERROR(500, "内部服务错误，请刷新后重试，如若刷新后还存在问题，请联系技术人员"),
//    BAD_GATEWAY(502, "Bad Gateway"),
    BAD_GATEWAY(502, "网关错误"),
//    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    GATEWAY_TIMEOUT(504, "网关超时"),
    MAX_UPLOAD_SIZE(509, "文件大小超出限制, 请压缩或降低文件质量!"),
    UPLOAD_FILE_ERROR(510, "上传文件异常！"),
   // RECORD_ALREADY_EXISTS(512, "已存在该记录"),
    FILE_NOT_FOUND(404, "系统找不到指定的文件"),
    NO_USER_EXIST(513, "用户名不存在"),
    NO_USER_REP(513, "用户名重复"),
        INVALID_PASSWORD(514, "密码错误"),
    NO_PERMISSION(515, "非法请求！"),
    NOT_MATCH(516, "用户名或密码错误"),
    INVALID_MOBILE(517, "无效的手机号码"),
    INVALID_EMAIL(518, "无效的邮箱"),
    REPEAT_MOBILE(519, "已存在此手机号"),
    REPEAT_EMAIL(520, "已存在此邮箱地址"),
    NO_RECORD(521, "没有查到相关记录"),
    No_FILE_SELECT(522, "未选择文件");
  //  DATA_REFERENCED(523,"该数据已被关联，不能移除");

    private int code;
    private String msg;

    RespStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
