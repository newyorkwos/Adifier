package com.adifier.interceptor;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: create add Interceptor config
 * @author: StevenWu
 * @create: 2019-03-29 18:13
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Autowired
//    LoginInterceptor loginInterceptor=new LoginInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/")
                .addPathPatterns("/api/v1/**")
                .addPathPatterns("/pr*/*");
    }
}
