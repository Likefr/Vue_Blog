package com.rz.controller;

import com.rz.util.JsonResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:    ExceptionController
 * Description:  异常处理Controller,在这里处理自己定义的异常
 * Author:       WangFZ
 * Date:         2021/9/13
 * Version:      1.0
 **/
@RestControllerAdvice
public class ExceptionController {
    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public JsonResult handle401(ShiroException e) {
        return new JsonResult(401, e.getMessage(), null);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public JsonResult handle401() {
        return new JsonResult(401, "Unauthorized", null);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult globalException(HttpServletRequest request, Throwable ex) {
        return new JsonResult(getStatus(request).value(), ex.getMessage(), null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
