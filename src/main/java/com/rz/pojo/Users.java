package com.rz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0 2021/9/12
 * @outhor Likefr
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users{
    private int id;
    /*@NotNull(message = "用户名不能为空")*/
    private String username;
    /*@NotNull(message = "密码不能为空")*/
    private String password;
    private String email;
    /*private String date;*/
}
