package com.rz.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rz.entity.User;
import com.rz.service.UserService;
import com.rz.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserRealm extends AuthorizingRealm {
//    RedisTemplate redisTemplate;

    @Autowired
    UserService service;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        String username = userToken.getUsername(); // 用户
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        User userVo = service.getOne(wrapper);
        if (userVo == null) { // 没有这个用户
            return  null;
        }

        String password = MD5Util.formPassToDBPass(String.valueOf(userToken.getPassword()),userVo.getSalt());
        userToken.setPassword(password.toCharArray());

        return new SimpleAuthenticationInfo(userVo, userVo.getPassword(),"");
    }
}
