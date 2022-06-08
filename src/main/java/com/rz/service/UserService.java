package com.rz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rz.entity.User;
import com.rz.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-05-29
 */
public interface UserService extends IService<User> {
    public IPage<User> queryUserList(IPage<User> page);
    User doLogin(HttpServletResponse response, LoginVo loginVo);
    User getUserByCookie(HttpServletResponse response,String userTicket);
}
