package com.example;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

    @Test
    public void method() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-DI-Array.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Array-2.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Array-3.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Array-4.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-List.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method6() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-List-2.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method7() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-List-3.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method8() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Set.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method9() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Set-2.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method10() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Set-3.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method11() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Map.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method12() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Map-2.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }

    @Test
    public void method13() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-DI-Map-3.xml");
        final Dept dept = context.getBean("dept", Dept.class);
        System.out.println(dept);
    }
}
