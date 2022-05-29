package com.rz.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rz.entity.ResultBean;
import com.rz.entity.ResultBeanEnum;
import com.rz.entity.UserVo;
import com.rz.mapper.UserMapper;
import com.rz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-05-29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;
//    添加 or 注册用户
    @PostMapping("/addUser")
    public ResultBean addUser(UserVo userData) {
        QueryWrapper<UserVo> wrapper = new QueryWrapper<UserVo>().select("username").eq("username", userData.getUsername());
        UserVo user = userMapper.selectOne(wrapper);
        if (user != null) {
            return ResultBean.error(ResultBeanEnum.USER_EXISTS_ERROR);
        }
        int insert = userMapper.insert(userData);
        if (insert > 0) {
            return ResultBean.success(insert);
        }
        return ResultBean.error(ResultBeanEnum.ADD_USER_ERROR);
    }

    // 删除
    @PostMapping("/delUser/{id}")
    public ResultBean delUser (@PathVariable("id") long delId) {
        int i = userMapper.deleteById(delId);
        if (i> 0) {
            return ResultBean.success();
        }
        return ResultBean.error(ResultBeanEnum.DEL_USER_ERROR);
    }
    // 修改用户信息
    @PostMapping("/updateUser")
        public ResultBean updateUser(UserVo userVo) {
        int i = userMapper.updateById(userVo);
        if (i > 0 ) {
            return ResultBean.success();
        }
        return ResultBean.error(ResultBeanEnum.UPDATE_USER_ERROR);
    }
    // 分页查询
    @PostMapping("/queryUserList")
    public ResultBean queryUserList (@RequestParam(defaultValue = "1") Integer currentPage,
                                     @RequestParam(defaultValue = "5") Integer size) {
        Page<UserVo> page = new Page(currentPage, size);
        IPage<UserVo> userVoIPage = userService.queryUserList(page);
        return ResultBean.success(userVoIPage);
    }
}
