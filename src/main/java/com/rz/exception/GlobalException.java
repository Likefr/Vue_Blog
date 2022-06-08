package com.rz.exception;

import com.rz.entity.ResultBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException{
    private ResultBeanEnum resultBeanEnum;
}
