package com.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhou
 * @Date: 2020/1/28 15:27
 */
public class CookieUtil {

    /**
     * 设置cookie
     * @param response
     * @param key
     * @param value
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse response,String key,String value,int maxAge){
        Cookie cookie = new Cookie(key,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
}
