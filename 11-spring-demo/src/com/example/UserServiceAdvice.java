package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserServiceAdvice {

    /**
     * ProceedingJoinPoint is only supported for around advice
     * org.springframework.beans.factory.BeanCreationException:
     * Error creating bean with name 'aopConfig': BeanPostProcessor before instantiation of bean failed;
     * nested exception is java.lang.IllegalArgumentException: ProceedingJoinPoint is only supported for around advice
     * <p>
     * at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:512)
     */
//    @Before(value = "execution(* com.example.*.*(..))")
//    public void before(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println(proceedingJoinPoint);
//        System.out.println(proceedingJoinPoint.getClass());
//        System.out.println(proceedingJoinPoint.getSignature());
//        System.out.println(proceedingJoinPoint.getArgs());
//        System.out.println(proceedingJoinPoint.getTarget());
//        System.out.println("before...");
//    }
    @Before(value = "execution(* com.example.*.*(..))")
    public void before(JoinPoint point) {
        System.out.println("------------------ before----------------");
        System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标方法为：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
        System.out.println();
    }

    @AfterReturning(pointcut = "execution(* com.example.*.*(..))", returning = "returnValue")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println("------------------ afterReturning ----------------");
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + returnValue);
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());
        System.out.println();
    }

    @After("execution(* com.example.*.*(..))")
    public void after(JoinPoint point) {
        System.out.println("------------------ after ----------------");
        System.out.println("@After：模拟释放资源...");
        System.out.println("@After：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@After：被织入的目标对象为：" + point.getTarget());
        System.out.println();
    }

    @Around("execution(* com.example.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("------------------ around-before----------------");
        System.out.println("@Around：执行目标方法之前...");
        //访问目标方法的参数：
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "改变后的参数1";
        }
        //用改变后的参数执行目标方法
        Object returnValue = point.proceed(args);
        System.out.println("------------------ around-after----------------");
        System.out.println("@Around：执行目标方法之后...");
        System.out.println("@Around：被织入的目标对象为：" + point.getTarget());
        System.out.println();
        return "原返回值：" + returnValue + "，这是返回结果的后缀";
    }

    //IllegalArgumentException: ProceedingJoinPoint is only supported for around advice
//    @AfterThrowing("execution(* com.example.*.*(..))")
//    public void afterThrowing(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("------------------ afterThrowing----------------");
//        //访问目标方法的参数：
//        Object[] args = point.getArgs();
//        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
//            args[0] = "改变后的参数1";
//        }
//        System.out.println("------------------ around-after----------------");
//        System.out.println("@AfterThrowing：执行目标方法之后...");
//        System.out.println("@AfterThrowing：被织入的目标对象为：" + point.getTarget());
//        System.out.println();
//    }

    @AfterThrowing(value = "execution(* com.example.*.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint point,Throwable ex) throws Throwable {
        System.out.println("------------------ afterThrowing----------------");
        System.out.println("@AfterThrowing ex:" + ex.getMessage());
        System.out.println("@AfterThrowing：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@AfterThrowing：执行目标方法之后...");
        System.out.println("@AfterThrowing：被织入的目标对象为：" + point.getTarget());
        System.out.println();
    }
}
