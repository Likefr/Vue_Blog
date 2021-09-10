package com.rz.controller;

import com.rz.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0 2021/9/10
 * @outhor Likefr
 */
@RestController
public class testController {

    @GetMapping("/test")    /*http://localhost:8080/test*/
    public JsonResult test() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "第一个标题");
        map.put("date", new Date().toLocaleString());
        return JsonResult.success(map);
    }
}
