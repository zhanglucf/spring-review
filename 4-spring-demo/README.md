### IOC 操作 Bean 管理（xml 自动装配）

#### 1 、什么是自动装配

（1）根据指定装配规则（属性名称或者属性类型），Spring 自动将匹配的属性值进行注入

#### 2 、演示自动装配过程

```xml
    <bean name="dept" class="com.example.Dept" autowire="byType"></bean>
    <bean name="dept2" class="com.example.Dept" autowire="byName"></bean>
    <bean name="emp" class="com.example.Emp"></bean>
```

