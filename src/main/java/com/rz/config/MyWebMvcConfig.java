package com.rz.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Likefr
 * @version 1.0 2021/9/11
 */
@SpringBootConfiguration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //前者为访问请求 路径(requestMapping) 后者为页面文件名
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index").setViewName("index");
    }

    //    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //添加映射路径
//        registry.addMapping("/**")
//                //是否发送Cookie
//                .allowCredentials(true)
//                //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
//                .allowedOriginPatterns("*")
//                //放行哪些请求方式
//                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
//                //.allowedMethods("*") //或者放行全部
//                //放行哪些原始请求头部信息
//                .allowedHeaders("*")
//                //暴露哪些原始请求头部信息
//                .exposedHeaders("*");
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui/index.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
