### `通知`中如何获请求参数 方法名 返回值

- 在环绕通知中使用`ProceedingJoinPoint`接收目标对象的一些元数据

- 在非环绕通知使用`JoinPoint`接收目标对象的一些元数据

- 在异常通知中使用`Throwable`接收异常对象类，

#### 需要注意的点：

- `Throwable`变量名需要在`@AfterThrowing`注解中通过`throwing`属性指定
- 如果异常通知中还需接收`JoinPoint`对象，这个时候需要把`JoinPoint`作为第一个参数，`Throwable`参数作为第二个参数

```java
    @AfterThrowing(value = "execution(* com.example.*.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint point,Throwable ex) throws Throwable {
        //...
    }
```

#### `ProceedingJoinPoint`与`JoinPoint`的区别：

![image-20210530144603175](E:\spring\11-spring-demo\image-20210530144603175.png)

- `ProceedingJoinPoint`是`JoinPoint`的子类

- `ProceedingJoinPoint`除了和`JoinPoint`一样可以获取参数、方法名之类的属性，还可以执行proceed()执行目标方法

  

### 下一节研究spring中的事务