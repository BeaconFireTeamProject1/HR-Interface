package com.example.hrinterface.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
public class RequestHandler {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.example.hrinterface.controller.*)")
    public void controller(){}

    @Pointcut("execution(* com.example.hrinterface.dao.*.*(..))")
    public void daoMethod(){}

    @Pointcut("execution(* com.example.hrinterface.controller.*.*(..))")
    public void controllerMethod(){}

    @Around("daoMethod()")
    public Object executionTimeAdvice(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.currentTimeMillis();
        log.warn("before processed");

        Object result = pjp.proceed();

        long elapsedTime = System.currentTimeMillis() - startTime;
        String className = pjp.getSignature().getDeclaringTypeName();
        String methodName = pjp.getSignature().getName();
        log.warn(className+"."+methodName+" execution time: "+elapsedTime+" ms result: "+result);
        return result;
    }

    @Around("controller() && args(..,request)")
    public Object requestAdvice(ProceedingJoinPoint pjp, HttpServletRequest request) throws Throwable{
        log.warn("Entering in Method :  " + pjp.getSignature().getName());
        log.warn("Class Name :  " + pjp.getSignature().getDeclaringTypeName());
        log.warn("Arguments :  " + Arrays.toString(pjp.getArgs()));
        log.warn("Target class : " + pjp.getTarget().getClass().getName());

        if (null != request) {
            log.warn("Start Header Section of request ");
            log.warn("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                log.warn("Header Name: " + headerName + " Header Value : " + headerValue);
            }
            log.warn("Request Path info :" + request.getServletPath());
            log.warn("End Header Section of request ");
        }

        Object result = pjp.proceed();
        log.warn("Method Return : " + result);
        return result;
    }
}
