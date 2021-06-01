### AOP

底层实现动态代理

额外需要的jar

1. com.springsource.net.sf.cglib-2.2.0.jar
2. com.springsource.org.aopalliance-1.0.0.jar
3. com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
4. spring-aop-5.2.6.RELEASE.jar

### 方式一：`xml`方式配置`aop`

#### 重点说下切点表达式：

- 只增强UserServiceImpl.findUser方法

```xml
<aop:pointcut id="usp" expression="execution(* com.example.UserServiceImpl.findUser(..))"/>
```

- 增强UserServiceImpl类的所有方法

```xml
<aop:pointcut id="usp" expression="execution(* com.example.UserServiceImpl.*(..))"/>
```

- 增强com.example包中所有类的方法

```xml
<aop:pointcut id="usp" expression="execution(* com.example.*.*(..))"/>
```

