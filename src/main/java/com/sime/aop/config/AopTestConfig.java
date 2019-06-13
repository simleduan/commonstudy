package com.sime.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面类
 */
@Aspect
@Component
public class AopTestConfig {

    /**
     * 包下面所有接口的所有方法，包括参数
     */
    @Pointcut("execution(* com.sime.aop.services.*.*(..))")
    public void pointcut(){

    }

    @Before("com.sime.aop.config.AopTestConfig.pointcut()")
    public void before(){
        System.out.println("i am is before");
    }

    @After("com.sime.aop.config.AopTestConfig.pointcut()")
    public void after(){
        System.out.println("i am is after");
    }

    @Around("com.sime.aop.config.AopTestConfig.pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用时间为："+String.valueOf(end-start));
        return proceed;
    }
}
