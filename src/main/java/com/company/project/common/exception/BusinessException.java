package com.company.project.common.exception;

import com.company.project.common.result.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 自定义业务异常
 * </p>
 *
 * @author LiLittleCat
 */
@Getter
@Setter
@ToString
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -5186733845539146091L;

    private final ResultCodeEnum resultCodeEnum;

    public BusinessException(String message, ResultCodeEnum resultCodeEnum) {
        super(message);
        this.resultCodeEnum = resultCodeEnum;
    }

    public BusinessException(String message) {
        super(message);
        this.resultCodeEnum = ResultCodeEnum.FAIL;
    }

}
