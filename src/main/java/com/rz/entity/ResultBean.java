package com.rz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean {
    private int code;
    private String message;
    private Object data;
    public static ResultBean success(){
        return new ResultBean(ResultBeanEnum.SUCCESS.getCode(),ResultBeanEnum.SUCCESS.getMeassage(),null);
    }

    public static ResultBean success(Object data){
        return new ResultBean(ResultBeanEnum.SUCCESS.getCode(),ResultBeanEnum.SUCCESS.getMeassage(), data);
    }
    public static ResultBean error(ResultBeanEnum resultBeanEnum){
        return new ResultBean(resultBeanEnum.getCode(),resultBeanEnum.getMeassage(),null);
    }
    public static ResultBean error(ResultBeanEnum resultBeanEnum,Object data){
        return new ResultBean(resultBeanEnum.getCode(),resultBeanEnum.getMeassage(),data);
    }
}
