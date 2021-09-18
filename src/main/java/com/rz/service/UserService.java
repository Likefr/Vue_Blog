package com.rz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rz.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2021-09-13
 */
public interface UserService extends IService<User> {
    User getUserByUsername(String username);

    List<User> queryAllUser();
}
