package com.example;

public class Dog {
    private String name;

    public Dog() {
        System.out.println("第一步 执行了无参构造方法");
    }

    public String getName() {
        System.out.println("第六步 调用对象的getName方法");
        return name;
    }

    public void setName(String name) {
        System.out.println("第二步 给name属性赋值");
        this.name = name;
    }

    private void init(){
        System.out.println("第四步 执行了对象初始化方法");
    }

    private void destroy(){
        System.out.println("第七步 执行了对象销毁方法");
    }
}
