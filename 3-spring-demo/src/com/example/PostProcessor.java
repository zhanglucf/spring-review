package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步 执行后置处理器的postProcessBeforeInitialization  beanName:" + beanName + "class:" + bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步 执行后置处理器的postProcessBeforeInitialization beanName:" + beanName + "class:" + bean.getClass());
        return bean;
    }
}
