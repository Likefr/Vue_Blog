package com.rz.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResultBeanEnum {
    SUCCESS(200,"SUCCESS"),
    ERROR(500, "服务的异常"),
    // 登录模块
    NOLOGIN_ERROR(500100,"未登录"),
    ADD_USER_ERROR(500210, "添加用户失败"),
    DEL_USER_ERROR(500102,"删除用户失败"),
    UPDATE_USER_ERROR(500102,"修改用户失败"),
    USER_EXISTS_ERROR(500403, "该用户名已存在"),
    MOBILE_ERROR(500211, "手机号码格式不正确"),
    MOBILE_NOT_EXIST(500211, "手机号码不存在"),
    BIND_ERROR(500213, "参数校验异常"),
    SESSION_ERROR(500215, "用户不存在"),
    PASSWORLD_UPDATE_FAIL(500214, "密码更新失败"),
    // 秒杀模块
    EMPTY_ERROR(500501, "库存为空"),
    LIMIT_ERROR(500502, "该商品每人限购一件");
    private final Integer code;
    private final String meassage;
}
