package com.adifier.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;


/**
 * 描述:
 * reate AOP
 *
 * @author StevenWu
 * @create 2019-03-26-15:59
 */
@Aspect
@Component
public class LogAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.adifier.*.*.*(..))")
    public void log(){

    }

//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint) {
//
//        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request=attributes.getRequest();
//        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+ "." +joinPoint.getSignature().getName();
//        RequestLog requestLog=new RequestLog(
//                request.getRequestURL().toString(),
//                request.getRemoteAddr(),
//                classMethod,
//                joinPoint.getArgs()
//        );
//
//        logger.info("Request-----{}", requestLog);
//    }

    @Around("log()")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Time aspect start");
        Object[] args=pjp.getArgs();
        for (Object arg: args){
            System.out.println("arg is "+arg);
        }
        long start=new Date().getTime();
        Object object=pjp.proceed();
        System.out.println("time aspect take times: "+(new Date().getTime()-start) );
        System.out.println("Time aspect end");
        return object;
    }

//    @After("log()")
//    public void doAfter(){
//        //logger.info("---------- doAfter 2 ----------");
//    }
    @AfterReturning(returning="result" , pointcut="log()")
    public void doAfterReturning(Object result){

        logger.info("Return ---------- {}", result);
    }

    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
