### Spring5 框架概述

1. Spring 是轻量级的开源的 JavaEE 框架

2. Spring 可以解决企业应用开发的复杂性

3. Spring 有两个核心部分：IOC 和 Aop

   - IOC：控制反转，把创建对象过程交给 Spring 进行管理

   - Aop：面向切面，不修改源代码进行功能增强

### Spring 特点

1. 方便解耦，简化开发
2. Aop 编程支持
3. 方便程序测试
4. 方便和其他框架进行整合
5. 方便进行事务操作
6. 降低 API 开发难度

### spring开发需要基础包

1. spring-beans-5.2.6.RELEASE.jar
2. spring-context-5.2.6.RELEASE.jar
3. spring-core-5.2.6.RELEASE.jar
4. spring-expression-5.2.6.RELEASE.jar
5. commons-logging-1.1.1.jar

### 什么是 IOC

1. 控制反转，把对象创建和对象之间的调用过程，交给 Spring 进行管理

2. 使用 IOC 目的：为了耦合度降低

3. IOC 思想基于 IOC 容器完成，IOC 容器底层就是对象工厂

### Spring 提供 IOC 容器实现两种方式：（两个接口）

- #### BeanFactory：


   IOC 容器基本实现，是 Spring 内部的使用接口，不提供开发人员进行使用
加载配置文件时候不会创建对象，在获取对象（使用）才去创建对象

- #### ApplicationContext：

   BeanFactory 接口的子接口，提供更多更强大的功能，一般由开发人
员进行使用加载配置文件时候就会把在配置文件对象进行创建

### DI的几种方式：

#### set方法注入：

```xml
<!--    使用set方法完成注入-->   
<bean name="book" class="com.example.Book">
        <property name="name" value="滕王阁序"></property>
 </bean>
```

#### 构造器注入

```xml
<!--    使用有参构造器完成注入-->   
<bean name="book" class="com.example.Book">
        <constructor-arg name="name" value="滕王阁序"/>
</bean>
```

#### p标签注入，简化set方法注入

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--    使用有参构造器完成注入-->
    <bean name="book" class="com.example.Book" p:name="滕王阁序"/>
</beans>
```



### 注入其他类型属性

#### null值    

> 使用 <null/>标签

```xml
    <!--    注入null类型参数-->
    <bean name="book" class="com.example.Book">
        <property name="name" >
            <null/>
        </property>
    </bean>
```



#### 特殊符号 

> 使用<![CDATA[]]> 标签

```xml
  <!--    参数类型为特殊符号-->
    <bean name="book" class="com.example.Book">
        <property name="name">
          <value><![CDATA[<<滕王阁序>>]]></value>
        </property>
    </bean>
```



#### 注入对象引用  

> ref

方式一：外部bean

```xml
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="奥迪集团"></property>
        <property name="em" ref="emp"></property>
    </bean>

    <bean name="emp" class="com.example.Emp"></bean>
```

方式一：内部bean

```xml
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="奥迪集团"></property>
        <property name="em">
            <bean name="empName" class="com.example.Emp"></bean>
        </property>
    </bean>
```

#### 注入对象引用  + 对象属性

方式一：常规写法

```xml
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="奥迪集团"></property>
        <property name="em" ref="emp"></property>
    </bean>
    <bean name="emp" class="com.example.Emp">
        <property name="name" value="Jack"></property>
    </bean>
```

方式二：属性级联

```xml
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="奥迪集团"></property>
        <property name="em" ref="emp"></property>
        <property name="em.name" value="Tom"></property>
    </bean>
    <bean name="emp" class="com.example.Emp"></bean>
```

方式三：属性级联

```xml
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="奥迪集团"></property>
        <property name="em">
            <bean name="empName" class="com.example.Emp"></bean>
        </property>
        <property name="em.name" value="Jack"></property>
    </bean>
```

