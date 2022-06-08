package com.rz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rz.entity.ResultBeanEnum;
import com.rz.entity.User;
import com.rz.exception.GlobalException;
import com.rz.mapper.UserMapper;
import com.rz.service.UserService;
import com.rz.util.CookieUtil;
import com.rz.util.UUIDUtil;
import com.rz.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Likefr Vue Blog
 * @since 2022-05-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public IPage<User> queryUserList(IPage<User> page) {
        return userMapper.queryUserList(page);
    }

    @Override
    public User doLogin(HttpServletResponse response, LoginVo loginVo) {
        String password = loginVo.getPassword();
        String username = loginVo.getUsername();
        if (!StringUtils.isNotEmpty(username) && !StringUtils.isNotEmpty(password)) {
            throw new GlobalException(ResultBeanEnum.USER_NULL_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
        } catch (Exception e) { // 只要有异常就代表登录失败
            throw new GlobalException(ResultBeanEnum.LOGIN_ERROR);
        }
        Subject subject1 = SecurityUtils.getSubject();
        User user = (User) subject1.getPrincipal();
        String uuid = UUIDUtil.uuid();
        user.setPassword(null);
        user.setSalt(null);
        redisTemplate.opsForValue().set("user:" + uuid,user);
        CookieUtil.setCookie(response, "userTicket", uuid, -1);
        return user;
    }

    @Override
    public User getUserByCookie(HttpServletResponse response,String userTicket) {
        if (org.springframework.util.StringUtils.isEmpty(userTicket)) {
            System.out.println("未登录");
            return null;
        }

        User userInfo =(User) redisTemplate.opsForValue().get("user:" + userTicket);
        if (userInfo != null) {
            CookieUtil.setCookie(response, "userTicket", userTicket, -1);
        }
        return userInfo;
    }
}
