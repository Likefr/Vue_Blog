package com.rz.controller;

import com.rz.config.jwt.JwtUtil;
import com.rz.entity.User;
import com.rz.service.impl.UserServiceImpl;
import com.rz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    @CrossOrigin
    public JsonResult login(@RequestBody User users) {
        String username = users.getUsername();
        String password = users.getPassword();
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return JsonResult.err("account not found");
        }
        if (!user.getPassword().equals(users.getPassword())) {
            return JsonResult.err("invalid password");
        }
        System.out.println("Login success Token :" + JwtUtil.sign(username,password));
        return JsonResult.success("login success", JwtUtil.sign(username,password));
    }

}
