package com.rz.service;

import com.rz.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
