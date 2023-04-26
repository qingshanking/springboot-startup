package com.yanqingshan.admin.constant.enums;

/**
 * @Classname ServiceExceptionEnum
 * @Description 服务异常枚举
 * @Version 1.0.0
 * @Date 2023/4/26 21:29
 * @Created by yanqs
 */
public enum ServiceExceptionEnum {
    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(1, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(1, "参数缺失"),
    INVALID_REQUEST_PARAM_ERROR(1, "请求参数不合法"),

    // ========== 用户模块 ==========
    USER_NOT_FOUND(1, "用户不存在"),

    // ========== 订单模块 ==========

    // ========== 商品模块 ==========
    ;

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误提示
     */
    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
