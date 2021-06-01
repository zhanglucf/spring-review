package com.example;

public class Emp {

    private String name;

    public Emp() {
        System.out.println("执行了无参构造器。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
