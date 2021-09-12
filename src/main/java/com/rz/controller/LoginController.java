package com.rz.controller;

import com.rz.pojo.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0 2021/9/12
 * @outhor Likefr
 */
@RestController
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public void login(Users users) {
        log.info("------> id " + users.getId());
        log.info("------> username " + users.getUsername());
        log.info("------> password " + users.getPasswrod());
        log.info("------> email" + users.getEmail());
    }

}
