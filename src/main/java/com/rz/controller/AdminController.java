package com.rz.controller;

import com.rz.config.jwt.JwtUtil;
import com.rz.entity.Article;
import com.rz.entity.User;
import com.rz.mapper.ArticleMapper;
import com.rz.service.impl.UserServiceImpl;
import com.rz.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0 2021/9/16
 * @outhor Likefr
 */
@RestController
public class AdminController {

    @Autowired
    ArticleMapper articleMapper;
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
        System.out.println("Login success Token :" + JwtUtil.sign(username, password));
        Map<String, String> list = new HashMap<>();
        list.put("JWT", JwtUtil.sign(username, password));
        list.put("user", users.getUsername());
        return JsonResult.success("login success", list);
    }

    @RequestMapping("/getArticle")  //获取所有文章
    @CrossOrigin
    public JsonResult getArticle() {
        List<Article> articles = articleMapper.selectList(null);
        return JsonResult.success(articles);
    }

    @GetMapping("/queryAllUser")
    @CrossOrigin
    public JsonResult queryAllUser() {
        List<User> users = userService.queryAllUser();
        return JsonResult.success(users);
    }
}
