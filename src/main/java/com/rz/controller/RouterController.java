package com.rz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0 2021/9/11
 * @outhor Likefr
 */
@Controller
public class RouterController {

    @RequestMapping("/")
    public String index(){
        return "/index";
    }
}
