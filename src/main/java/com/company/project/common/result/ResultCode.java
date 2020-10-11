package com.company.project.common.result;

import lombok.Getter;

/**
 * <p>
 * 响应状态码
 * </p>
 *
 * @author LiLittleCat
 * @since 2020/8/30
 */
@Getter
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(400, "失败"),
    /**
     * 请求参数有误
     */
    PARAMETER_INVALID(412, "请求参数有误"),

    // 根据实际情况添加响应状态码...
    ;
    /**
     * 响应码
     */
    private final Integer code;
    /**
     * 响应内容
     */
    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
