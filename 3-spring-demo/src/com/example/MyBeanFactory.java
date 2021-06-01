package com.example;


import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<Emp> {

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Emp getObject() throws Exception {
        final Emp emp = new Emp();
        emp.setName("张三");
        return emp;
    }
}
