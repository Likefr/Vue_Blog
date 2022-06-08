package com.rz.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static String getCookie(HttpServletRequest request, String cookieName){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    /**
     * @param response
     * @param cookieName
     * @param value
     * @param cookieMaxAge 单位秒
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String value, int cookieMaxAge){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(cookieMaxAge);
        response.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse response, String cookieName){
        setCookie(response,cookieName,null,0);
    }
}
