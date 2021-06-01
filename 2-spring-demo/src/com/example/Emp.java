package com.example;

public class Emp {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Emp setName");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                '}';
    }
}
