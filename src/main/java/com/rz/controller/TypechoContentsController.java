package com.rz.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rz.entity.ResultBean;
import com.rz.entity.TypechoContents;
import com.rz.mapper.TypechoContentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-06-05
 */
@RequestMapping("/contents")
@RestController
public class TypechoContentsController {
    @Autowired
    TypechoContentsMapper typechoContentsMapper;
    // 分页查询
    @PostMapping("/queryContents")
    @CrossOrigin
    public ResultBean queryContents (@RequestParam(defaultValue = "1") Integer currentPage,
                                     @RequestParam(defaultValue = "5") Integer size) {
        Page<TypechoContents> page = new Page(currentPage, size);
        IPage<TypechoContents> userVoIPage = typechoContentsMapper.queryContents(page);

        return ResultBean.success(userVoIPage);
    }
}
