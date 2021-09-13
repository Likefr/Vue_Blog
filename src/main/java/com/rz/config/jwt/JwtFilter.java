package com.rz.config.jwt;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:    JwtFilter
 * Description:  TODO
 * Author:       WangFZ
 * Date:         2021/9/13
 * Version:      1.0
 **/
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 从请求头中获取authorization信息,如果有说明携带了token
     * header中是以("Authorization":"token")形式携带token的
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response){
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }

    /**
     * 执行登录方法,登录会调用自定义realm的doAuthenticationInfo方法
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response){
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        JwtToken token = new JwtToken(authorization);
        getSubject(request,response).login(token);
        return true;
    }

    /**
     * 携带了token的请求需要进行login验证
     * 没有携带token的请求直接通过
     * 这需要在受限资源前面添加 @RequiresAuthentication 注解
     * 不可以让未认证用户访问到受限资源
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        if(isLoginAttempt(request,response)){
            try{
                executeLogin(request,response);
            }catch(Exception e){
                response401(request,response);
            }
        }
        return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 将非法请求跳转到 /401
     */
    private void response401(ServletRequest req, ServletResponse resp) {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.sendRedirect("/401");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
