### FactoryBean 



> demo1和demo2中在xml中配置的bean我们称其为普通bena
>
> `spring`管理的bean分为两种
>
>    1. 普通bean: 在xml中配置的bean我们称其为普通bean
>    2. FactoryBean: 实现了FactoryBean接口产生的bean

```java
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
```

```java
    @Test
    public void method() {
        //普通bean 执行下面方法时就会调用类的构造器，初始化对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        for (int i = 0; i < 10; i++) {
            //FactoryBean 执行下面方法时才会调用类的构造器，初始化对象
            final Emp emp = context.getBean("myFactoryBean", Emp.class);
            System.out.println(emp);
        }
    }
```

输出：

```java
执行了无参构造器。。。
com.example.Emp@e1de817
com.example.Emp@e1de817
com.example.Emp@e1de817
com.example.Emp@e1de817
com.example.Emp@e1de817
```

### Bean的生命周期一

> 解释：`bean`的创建和销毁过程

1. 通过构造器创建对象
2. 给bean的属性赋值
3. 调用bean的初始化方法（需要配置）
4. 获取bean,调用bean的方法
5. 当容器关闭时，执行bean的销毁方法（需要配置）

```xml
    <bean name="dog" class="com.example.Dog" init-method="init" destroy-method="destroy">
        <property name="name" value="大黄"></property>
    </bean>
```

> `init-method` 和 `destroy-method` 指定bean的初始化和销毁方法

```java
    @Test
    public void method3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-life-cycle.xml");
        final Dog dog = context.getBean("dog",Dog.class);
        dog.getName();
        ((ClassPathXmlApplicationContext)context).close();
    }

out:
Connected to the target VM, address: '127.0.0.1:55102', transport: 'socket'
第一步 执行了无参构造方法
第二步 给name属性赋值
第三步 执行了对象初始化方法
第四步 调用对象的getName方法
第五步 执行了对象销毁方法
Disconnected from the target VM, address: '127.0.0.1:55102', transport: 'socket'

Process finished with exit code 0
```



### Bean的生命周期二

1. 通过构造器创建对象
2. 给bean的属性赋值
3. 执行后置处理器的postProcessBeforeInitialization方法
4. 调用bean的初始化方法（需要配置）
5. 执行后置处理器的postProcessAfterInitialization方法
6. 获取bean,调用bean的方法
7. 当容器关闭时，执行bean的销毁方法（需要配置）

```java
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

```



```xml
    <bean name="dog" class="com.example.Dog" init-method="init" destroy-method="destroy">
        <property name="name" value="大黄"></property>
    </bean>
<!--    单独的一个类  实现了BeanPostProcessor接口 然后其他bean在init时，都会执行到这个类的两个方法-->
<!--    需要注意的是，自身并不会执行到这两个方法-->
<!--    可以定义BeanPostProcessor多个实现，那个先定义那个先执行到-->
    <bean name="postProcessor" class="com.example.PostProcessor"></bean>
<!--    <bean name="postProcessor2" class="com.example.PostProcessor2"></bean>-->
```



```java
    @Test
    public void method3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-life-cycle.xml");
        final Dog dog = context.getBean("dog",Dog.class);
        dog.getName();
        ((ClassPathXmlApplicationContext)context).close();
    }
```

out:

```text
Connected to the target VM, address: '127.0.0.1:57192', transport: 'socket'
第一步 执行了无参构造方法
第二步 给name属性赋值
第三步 执行后置处理器的postProcessBeforeInitialization  beanName:dogclass:class com.example.Dog
第四步 执行了对象初始化方法
第五步 执行后置处理器的postProcessBeforeInitialization beanName:dogclass:class com.example.Dog
第六步 调用对象的getName方法
第七步 执行了对象销毁方法
Disconnected from the target VM, address: '127.0.0.1:57192', transport: 'socket'
```















