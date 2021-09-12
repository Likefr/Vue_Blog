package com.rz.controller;

import com.rz.pojo.Users;
import com.rz.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0 2021/9/12
 * @outhor Likefr
 */
@RestController
@Slf4j
public class LoginController {

    @PostMapping("/login")
    @CrossOrigin//解决跨域
    public JsonResult login(@RequestBody Users users) {
/*
          log.info("------> id " + users.getId()); //获取用户id
          log.info("------> email" + users.getEmail());//获取用户邮件
*/

        log.info("------> username " + users.getUsername());
        log.info("------> password " + users.getPassword());

        // 认证...

        return JsonResult.success("登录成功", null);  //msg: 告诉前端是否登录成功
    }

}
