package com.company.project.common.result;

import lombok.Getter;

/**
 * <p>响应状态码</p>
 *
 * @author LiLittleCat
 */
@Getter
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS("200", "成功"),
    /**
     * 失败
     */
    FAIL("400", "失败"),
    /**
     * 请求参数有误
     */
    PARAMETER_INVALID("412", "请求参数有误"),
    /**
     * 未知异常，请联系管理员
     */
    UNKNOWN_ERROR("500", "未知异常，请联系管理员"),

    // 根据实际情况添加响应状态码...
    ;
    /**
     * 响应码
     */
    private final String code;
    /**
     * 响应描述
     */
    private final String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
