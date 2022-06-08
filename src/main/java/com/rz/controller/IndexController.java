package com.rz.controller;

import com.rz.entity.ResultBean;
import com.rz.entity.ResultBeanEnum;
import com.rz.entity.User;
import com.rz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0 2021/9/15
 * @outhor Likefr
 */
@RestController
public class IndexController {

@Autowired
    UserServiceImpl userService;
    @RequestMapping("/index")
    public ResultBean index(HttpServletResponse response, @CookieValue("userTicket") String cookie){
        User userByCookie = userService.getUserByCookie(response, cookie);
        if (userByCookie == null) {
            return ResultBean.error(ResultBeanEnum.NOLOGIN_ERROR);
        }
        return ResultBean.success(userByCookie);
}
}
