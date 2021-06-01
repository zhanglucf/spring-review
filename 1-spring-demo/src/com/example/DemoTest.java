package com.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void method(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean1.xml");
        final User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void method2(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-DI-Set.xml");
        final Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void method3(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Constructor.xml");
        final Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void method4(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-p-tag.xml");
        final Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void method5(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-null.xml");
        final Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void method6(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-special-symbols.xml");
        final Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }


    @Test
    public void method7(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Ref.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method8(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Internal-Ref.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method9(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Ref-other.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method10(){
        final ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Internal-Ref-other.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }
}
