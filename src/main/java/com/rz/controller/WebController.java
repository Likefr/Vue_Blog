package com.rz.controller;

import com.rz.entity.User;
import com.rz.service.UserService;
import com.rz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public JsonResult login(@RequestParam String username,@RequestParam String password){
        User user = userService.getUserByUsername(username);
        if(user == null){
            return JsonResult.err("account not found");
        }

        if(!user.getPassword().equals(password)){
            return JsonResult.err("invalid password");
        }

        return JsonResult.success("login success");
    }
}
