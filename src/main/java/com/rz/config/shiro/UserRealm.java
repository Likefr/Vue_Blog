package com.rz.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

@Slf4j
public class UserRealm extends AuthorizingRealm {
//    RedisTemplate redisTemplate;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("执行了授权");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("执行了认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        String mobile = userToken.getUsername(); // 用户

//        UserVo userVo = mapper.selectById(mobile);
//        if (userVo == null) { // 没有这个用户
//            return null;
//        }
//
//        String password = MD5Util.formPassToDBPass(String.valueOf(userToken.getPassword()),userVo.getSlat());
//        userToken.setPassword(password.toCharArray());

        return new SimpleAuthenticationInfo(null, null,"");
    }
}
