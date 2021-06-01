package com.example;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void method() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        for (int i = 0; i < 10; i++) {
            final Emp emp = context.getBean("myFactoryBean", Emp.class);
            System.out.println(emp);
        }
    }

    @Test
    public void method3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-life-cycle.xml");
        final Dog dog = context.getBean("dog",Dog.class);
        dog.getName();
        ((ClassPathXmlApplicationContext)context).close();
    }

}
