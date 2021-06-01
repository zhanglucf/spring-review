package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor2 implements BeanPostProcessor {
    private String name;

    public PostProcessor2() {
//        System.out.println("第一步 执行了无参构造方法");
    }

    public String getName() {
//        System.out.println("第六步 调用对象的getName方法");
        return name;
    }
    public void test() {
//        System.out.println("第六步 test方法");
    }
    public void setName(String name) {
//        System.out.println("第二步 给name属性赋值");
        this.name = name;
    }

    private void init(){
//        System.out.println("第四步 执行了对象初始化方法");
    }

    private void destroy(){
//        System.out.println("第七步 执行了对象销毁方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步 执行后置处理器的postProcessBeforeInitialization2  beanName:" + beanName + "class:" + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步 执行后置处理器的postProcessBeforeInitialization2 beanName:" + beanName + "class:" + bean.getClass());
        return bean;
    }
}
