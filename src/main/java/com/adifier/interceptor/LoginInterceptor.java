package com.adifier.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: create interceptor for login
 * @author: StevenWu
 * @create: 2019-03-29 18:09
 **/

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("+++++++++++++preHandler start");
        //Get Class Name
        System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
        //Get Method Name
        System.out.println(((HandlerMethod)handler).getMethod().getName());

        if(request.getSession().getAttribute("user")== null){
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("+++++++++++post Handler end");
    }
}
