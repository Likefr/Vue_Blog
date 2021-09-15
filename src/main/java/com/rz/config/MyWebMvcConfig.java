package com.rz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Likefr
 * @version 1.0 2021/9/11
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //前者为访问请求 路径(requestMapping) 后者为页面文件名
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }


}
