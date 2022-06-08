package com.rz.controller;

import cn.licoy.encryptbody.annotation.decrypt.DecryptBody;
import com.rz.entity.ResultBean;
import com.rz.entity.User;
import com.rz.mapper.UserMapper;
import com.rz.service.impl.UserServiceImpl;
import com.rz.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl service;
    @PostMapping("/doLogin")
    @DecryptBody
    public ResultBean doLogin (HttpServletResponse response,@RequestBody LoginVo loginVo) {
        User user = service.doLogin(response,loginVo);
        return ResultBean.success(user);
    }
}
