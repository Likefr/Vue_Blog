package com.rz.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * ClassName:    JWToken
 * Description:  TODO
 * Author:       WangFZ
 * Date:         2021/9/13
 * Version:      1.0
 **/
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
