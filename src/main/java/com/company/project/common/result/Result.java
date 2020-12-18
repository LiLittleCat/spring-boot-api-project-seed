package com.company.project.common.result;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 接口响应体格式统一封装
 * </p>
 *
 * @author LiLittleCat
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@ApiModel(value = "接口响应体格式统一封装")
public class Result<T> {
    /**
     * 响应状态码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 附加信息
     */
    private T data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public Result(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), message);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResultCodeEnum.FAIL);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCodeEnum.FAIL.getCode(), message);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(ResultCodeEnum.FAIL, data);
    }
}
