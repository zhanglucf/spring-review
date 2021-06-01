package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class UserServiceAdvice {

    @Before(value = "execution(* com.example.*.*(..))")
    public void before(JoinPoint point){
        System.out.println("advice-1 before");
    }

    @AfterReturning(pointcut="execution(* com.example.*.*(..))", returning="returnValue")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println("advice-1 afterReturning");
    }

    @After("execution(* com.example.*.*(..))")
    public void after(JoinPoint point) {
        System.out.println("advice-1 after");
    }

    @Around("execution(* com.example.*.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("advice-1 around before");
        point.proceed();
        System.out.println("advice-1 around after");
    }

    @AfterThrowing(value = "execution(* com.example.*.*(..))")
    public void afterThrowing(){
        System.out.println("advice-1 afterThrowing");
    }
}
