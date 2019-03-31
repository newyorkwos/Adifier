package com.adifier.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: create add Inteceptor config
 * @author: StevenWu
 * @create: 2019-03-29 18:13
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor=new LoginInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/")
                .addPathPatterns("/api/v1/**")
                .addPathPatterns("/pr*/*");
    }
}
