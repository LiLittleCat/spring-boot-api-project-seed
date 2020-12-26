package com.company.project.common.exception;

import com.company.project.common.result.Result;
import com.company.project.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常处理器
 * </p>
 *
 * @author LiLittleCat
 */
@RestControllerAdvice
@Slf4j
@SuppressWarnings("rawtypes")
public class GlobalExceptionHandler {
    /**
     * 自定义异常
     *
     * @param e BusinessException
     * @return 接口响应体格式统一封装
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBaseException(BusinessException e) {
        log.error("exception is:[{}]", e.getMessage());
        return Result.fail(e.getResultCodeEnum(), e.getMessage());
    }

    /**
     * 未知异常
     *
     * @param e Exception
     * @return 接口响应体格式统一封装
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultCodeEnum.UNKNOWN_ERROR);
    }
}
