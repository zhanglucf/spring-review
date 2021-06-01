package com.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAdvice {

    @Before(value = "execution(* com.example.*.*(..))")
    public void before(){
        System.out.println("before...");
    }
}
