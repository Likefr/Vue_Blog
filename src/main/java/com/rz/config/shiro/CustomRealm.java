package com.rz.config.shiro;

import com.rz.config.jwt.JwtToken;
import com.rz.config.jwt.JwtUtil;
import com.rz.entity.User;
import com.rz.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * ClassName:    CustomRealm
 * Description:  TODO
 * Author:       WangFZ
 * Date:         2021/9/13
 * Version:      1.0
 **/
@Service
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    public boolean supports(AuthenticationToken token){
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        String username = JwtUtil.getUsername(token);

        if(username == null){
            throw new AuthenticationException("token invalid!");
        }

        User user = userService.getUserByUsername(username);
        if(user == null){
            throw new AuthenticationException("account not found!");
        }

        if(!JwtUtil.verify(token,username,user.getPassword())){
            throw new AuthenticationException("username or password invalid!");
        }

        return new SimpleAuthenticationInfo(token,token,this.getName());
    }
}
