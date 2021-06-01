package com.example;

/**
 * AOP 底层原理是动态代理，而且使用的是CGLIB
 * 所以，被增强类不需要实现接口也能被增强
 */
public class NoInterfaceObject {

    public void method(){
        System.out.println("com.example.NoInterfaceObject.method()");
    }

    private void method2(){
        System.out.println("private com.example.NoInterfaceObject.method2()");
    }

    protected void method3(){
        System.out.println("protected com.example.NoInterfaceObject.method3()");
    }
}
