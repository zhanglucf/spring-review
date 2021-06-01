package com.example.test;

import com.example.domain.Student;
import org.junit.Test;
import com.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class TestDemo {

    @Test
    public void method() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        final StudentService studentService = app.getBean("studentService", StudentService.class);
        Object[] args = {7L, "信息"};
        studentService.insert(args);
    }

    @Test
    public void method2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        final StudentService studentService = app.getBean("studentService", StudentService.class);
        final Student student = studentService.findById(1L);
        System.out.println(student);
    }

    @Test
    public void method3() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        final StudentService studentService = app.getBean("studentService", StudentService.class);
        final Student student = studentService.findById(1L);
        System.out.println(student);
    }

    @Test
    public void method4() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        final StudentService studentService = app.getBean("studentService", StudentService.class);
        final List<Student> studentList = studentService.findAll();
        System.out.println(studentList);
    }

    @Test
    public void method5() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        final StudentService studentService = app.getBean("studentService", StudentService.class);
        final List<Object[]> objects = new ArrayList<>();
        IntStream.range(5000,5001).forEach(i ->{
            Object[] array = {i , UUID.randomUUID().toString().replaceAll("-","")};
            objects.add(array);
        });
        studentService.batchInsert(objects);
    }
}
