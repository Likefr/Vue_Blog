package com.rz.exception;

import com.rz.entity.ResultBean;
import com.rz.entity.ResultBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultBean ExceptionHandler(Exception e){
        if (e instanceof GlobalException){
            GlobalException ex = (GlobalException) e;
            return ResultBean.error( ex.getResultBeanEnum());
        } else if(e instanceof BindException){
            BindException be = (BindException) e;
            ResultBean error = ResultBean.error(ResultBeanEnum.BIND_ERROR);
            error.setMessage("参数校验异常：" + be.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return error;
        }else if(e instanceof MissingRequestCookieException){

            return ResultBean.error(ResultBeanEnum.NOLOGIN_ERROR);
        }
        return ResultBean.error(ResultBeanEnum.ERROR);
    }
}
