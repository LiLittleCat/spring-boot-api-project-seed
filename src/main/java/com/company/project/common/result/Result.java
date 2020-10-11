package com.company.project.common.result;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 接口响应体格式统一封装
 * </p>
 *
 * @author LiLittleCat
 * @since 2020/8/30
 */
@Data
@ApiModel(value = "接口响应体格式统一封装")
public class Result<T> {
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 附加信息
     */
    private T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
