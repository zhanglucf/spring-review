package com.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void method3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        final Dept dept = context.getBean("dept",Dept.class);
        final Dept dept2 = context.getBean("dept2",Dept.class);
        System.out.println(dept);
        System.out.println(dept2);
        ((ClassPathXmlApplicationContext)context).close();
    }

}
