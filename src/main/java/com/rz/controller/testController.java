package com.rz.controller;

import com.rz.pojo.contents;
import com.rz.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0 2021/9/10
 * @outhor Likefr
 */
@RestController
public class testController {

    @GetMapping("/test")    /*http://localhost:8080/test*/

    public JsonResult test() {
        List<contents> list = new ArrayList<>();
        list.add(new contents(1, "第1个标题", "内容GHFDG内容GHFDG内容GHFDG内容GHFDG内容GHFDG内容GHFDG", "2021-05-05"));
        list.add(new contents(2, "第2个标题", "内ASDAqwerfasfSFA容", "2021-05-12"));
        list.add(new contents(3, "第3个标题", "内容ASDrgsdfAS", "2021-10-05"));
        list.add(new contents(3, "第3个标题", "内容ASDteryertAS", "2021-10-05"));
        list.add(new contents(3, "第3个标题", "内容ASDsdfAS", "2021-10-05"));
        list.add(new contents(3, "第3个标题", "内容ASDadfAS内容ASDAS内容ASDAS内容ASDAS内容ASDAS内容ASDAS内容ASDAS内ASDAS", "2021-10-05"));
        list.add(new contents(3, "第3个标题", "内容AasdasSDAS", "2021-10-05"));
        list.add(new contents(3, "第3个标题", "内容ASjhgjghyDAS", "2021-10-05"));

        return JsonResult.success(list);
    }
}
