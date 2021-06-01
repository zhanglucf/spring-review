package com.example;

public class Dept {
    private String name;

    private Emp em;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Dept setName");
        this.name = name;
    }

    public Emp getEm() {
        return em;
    }

    public void setEm(Emp em) {
        System.out.println("Dept setEm");
        this.em = em;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", em=" + em +
                '}';
    }
}
