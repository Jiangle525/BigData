package com.jiangle.bigevent.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jiangle.bigevent.pojo.Result;
import jakarta.validation.ValidationException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理器
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception exception) {
        exception.printStackTrace();
        return Result.error(StringUtils.hasLength(exception.getMessage()) ? exception.getMessage() : "操作失败");
    }

    // 请求参数异常处理器
    @ExceptionHandler(ValidationException.class)
    public Result handlerParamValidationException(ValidationException exception) {
        exception.printStackTrace();
        return Result.error(StringUtils.hasLength(exception.getMessage()) ? exception.getMessage() : "操作失败");
    }


}
