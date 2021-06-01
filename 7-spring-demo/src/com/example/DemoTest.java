package com.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void method3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
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
