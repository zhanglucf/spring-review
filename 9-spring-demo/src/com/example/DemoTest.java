package com.example;

import config.AopConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void method3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        final UserService userService = context.getBean("userService",UserService.class);
        userService.findUser();
        userService.deleteUser();
        userService.insertUser();
        userService.updateUser();
        final NoInterfaceObject noInterfaceObject = context.getBean("noInterfaceObject",NoInterfaceObject.class);
        noInterfaceObject.method();
        noInterfaceObject.method3();
    }

}
