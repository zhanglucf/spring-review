

### 方式三：完成注解方式配置`aop`

1. 目标类上使用`@Service`将对象交给`spring ioc`容器管理

2. 在通知类对象上使用`@Component` +` @Aspect`注解

3. 通过`@Configuration` + `@ComponentScan` + `@EnableAspectJAutoProxy` 代替方式二中`xml`中开启注解扫描和开启`aop`生成代理类

```java
@Configuration
@ComponentScan(basePackages = {"com.example"})
@EnableAspectJAutoProxy
public class AopConfig {
}
```

> `@ComponentScan` 的`basePackages`默认值为空数组，这个一定要指定要扫描的包的

下一节，重点研究各种`通知`的执行顺序