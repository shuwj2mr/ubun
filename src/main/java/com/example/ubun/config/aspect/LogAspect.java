package com.example.ubun.config.aspect;

import com.example.ubun.config.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    /**
     * https://www.cnblogs.com/gdwkong/p/9307673.html
     * https://www.cnblogs.com/wangshen31/p/9379197.html  ******
     */
    @Pointcut("@annotation(com.example.ubun.config.annotation.Log)")
    public void annotationPointcut() { };

    @Before("annotationPointcut()")
    public void before(JoinPoint joinPoint) {
        //都是基于反射和HandlerMethod springmvc拦截器差不多其实
        MethodSignature signature = (MethodSignature) joinPoint.getSignature ();
        Method method = signature.getMethod ();
        String name = method.getName ();
        Log annotation = method.getAnnotation (Log.class);
        System.out.println ("前置通知。。。");
    }

    @After("execution(* com.example.ubun.service.*.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println ("后置通知。。。");
    }
}
