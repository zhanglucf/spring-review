

### 方式二：注解方式配置`aop`

目标类上使用@Service将对象交给spring ioc容器管理

在通知类对象上使用@Component + @Aspect注解

在spring配置文件中开启注解扫描和开启aop生成代理对象

```xml
<context:component-scan base-package="com.example"></context:component-scan>
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```

