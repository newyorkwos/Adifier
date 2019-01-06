package com.adifier.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: create goble Exception class
 * @author: StevenWu
 * @create: 2019-01-04 15:09
 **/
@ControllerAdvice//統一的錯誤攔截器
public class GlobalExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * error catch
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value= Exception.class)
    public ModelAndView defaultErrorHandler( HttpServletRequest request, Exception e) throws Exception{

        logger.error("Request URL: {}, Exception: {}", request.getRequestURL(), e.getMessage());
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) !=null){
            throw e;
        }
        ModelAndView mav=new ModelAndView();
        mav.addObject("url", request.getRequestURL());
        mav.addObject("exception", e);
        mav.setViewName("error");
        return mav;
    }
}
