package com.example;

public class Book {

    private String name;

    public Book() {
        System.out.println("无参构造器执行了");
    }

    public Book(String name) {
        System.out.println("有参构造器执行了");
        this.name = name;
    }

    public String getName() {
        System.out.println("com.example.Book.getName() 执行了");
        return name;
    }

    public void setName(String name) {
        System.out.println("com.example.Book.setName() 执行了");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
