package com.adifier.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

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
        RequestLog requestLog=new RequestLog(
                request.getRequestURL().toString(),
                request.getRemoteAddr(),
                ((HandlerMethod)handler).getBean().getClass().getName(),
                ((HandlerMethod)handler).getMethod().getName()
        );
        logger.info("Request-----{}", requestLog);

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

    private class RequestLog{
        private String url;
        private String ip;
        private String className;
        private String classMethod;

        public RequestLog(String url, String ip, String className, String classMethod) {
            this.url = url;
            this.ip = ip;
            this.className = className;
            this.classMethod = classMethod;

        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", className='" + className + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    '}';
        }
    }
}
