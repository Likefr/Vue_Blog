package com.rz.controller;

import com.rz.pojo.contents;
import com.rz.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0 2021/9/10
 * @outhor Likefr
 */
@RestController
public class testController {
    static List<contents> list = new ArrayList<>();

    //模拟数据
    static {
        list.add(new contents(1, "第1个标题", "内容GHFDG内容GHFDG内容GHFDG内容GHFDG内容GHFDG内容GHFDG", "2021-05-05"));
        list.add(new contents(2, "第2个标题", "内ASDAqwerfasfSFA容", "2021-05-12"));
        list.add(new contents(3, "第3个标题", "内容ASDrgsdfAS", "2021-10-05"));
        list.add(new contents(4, "第4个标题", "内容ASDteryertAS", "2021-10-05"));
        list.add(new contents(5, "第5个标题", "内容ASDsdfAS", "2021-10-05"));
        list.add(new contents(6, "第6个标题", "内容ASDadfAS内容ASDAS内容ASDAS内容ASDAS内容ASDAS内容ASDAS内容ASDAS内ASDAS", "2021-10-05"));
        list.add(new contents(7, "第7个标题", "内容AasdasSDAS", "2021-10-05"));
        list.add(new contents(8, "第8个标题", "内容ASjhgjghyDAS", "2021-10-05"));
    }

    @GetMapping("/test")    /*http://localhost:8868/test   Or  ../ */
    public JsonResult test() {
        return JsonResult.success(list);
    }



/*    @GetMapping("/archives/{id}.html")//获取文章
    public JsonResult archives(@PathVariable("id") int id) {
        contents contents = list.get(id);
        return JsonResult.success(contents);
    }*/
}
