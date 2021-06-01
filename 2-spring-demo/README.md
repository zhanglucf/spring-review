### DI 注入String数组

```java
public class Dept {
   private String[] tagsArray;
 
    //省略set方法
}
```

```xml
    <!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="tagsArray">
            <array>
                <value>高效</value>
                <value>团结</value>
                <value>活跃</value>
            </array>
        </property>
    </bean>
```

### DI 注入对象数组

```java
public class Dept {
    private Emp[] empArray;
 
    //省略set方法
}
```

#### 方式一：内部bean注入

> 只能注入一个元素

```xml
<!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="empArray">
           <bean name="emp" class="com.example.Emp">
               <property name="name" value="张三"></property>
           </bean>
        </property>
    </bean>
```

#### 方式二：外部bean注入

> 只能注入一个元素

```xml
<!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="滕王阁序"></property>
        <property name="empArray" ref="emp"></property>
    </bean>
    <bean name="emp" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>
```

#### 方式三：外部bean注入

```xml
 <!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="empArray">
            <array>
                <ref bean="emp1"></ref>
                <ref bean="emp2"></ref>
                <ref bean="emp3"></ref>
            </array>
        </property>
    </bean>

    <bean name="emp1" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>

    <bean name="emp2" class="com.example.Emp">
        <property name="name" value="李四"></property>
    </bean>

    <bean name="emp3" class="com.example.Emp">
        <property name="name" value="王五"></property>
    </bean>
```

### DI 注入List集合属性

```java
public class Dept {
    private List<Emp> empList;
    //省略set方法
}
```

#### 方式一：使用`array`标签

```xml
<!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="滕王阁序"></property>
        <property name="empList">
            <array>
                <ref bean="emp1"></ref>
                <ref bean="emp2"></ref>
                <ref bean="emp3"></ref>
            </array>
        </property>
    </bean>
    <bean name="emp1" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>
    <bean name="emp2" class="com.example.Emp">
        <property name="name" value="李四"></property>
    </bean>
    <bean name="emp3" class="com.example.Emp">
        <property name="name" value="王五"></property>
    </bean>
```



#### 方式二：使用`list`标签

``` xml
 <!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="滕王阁序"></property>
        <property name="empList">
            <list>
                <ref bean="emp1"></ref>
                <ref bean="emp2"></ref>
                <ref bean="emp3"></ref>
            </list>
        </property>
    </bean>

    <bean name="emp1" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>

    <bean name="emp2" class="com.example.Emp">
        <property name="name" value="李四"></property>
    </bean>

    <bean name="emp3" class="com.example.Emp">
        <property name="name" value="王五"></property>
    </bean>
```

#### 方式三：抽取公共集合

```xml
    <!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="滕王阁序"></property>
        <property name="empList" ref="commonList"></property>
    </bean>

    <util:list id="commonList">
        <bean name="emp1" class="com.example.Emp">
            <property name="name" value="张三"></property>
        </bean>
        <bean name="emp2" class="com.example.Emp">
            <property name="name" value="李四"></property>
        </bean>
        <bean name="emp3" class="com.example.Emp">
            <property name="name" value="王五"></property>
        </bean>
    </util:list>
```

### DI 注入Set集合属性

```java
public class Dept {
    private Set<Emp> empSet;
 //省略set方法   
}
```

#### 方式一：使用`array`标签

> 下面场景set中只有一个对象emp1

```xml

    <!--    使用set方法完成注入-->
    <bean name="dept" class="com.example.Dept">
        <property name="name" value="滕王阁序"></property>
        <property name="empSet">
            <array>
                <ref bean="emp1"></ref>
                <ref bean="emp1"></ref>
                <ref bean="emp1"></ref>
            </array>
        </property>
    </bean>

    <bean name="emp1" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>

    <bean name="emp2" class="com.example.Emp">
        <property name="name" value="李四"></property>
    </bean>

    <bean name="emp3" class="com.example.Emp">
        <property name="name" value="王五"></property>
    </bean>
```



#### 方式二：使用`set`标签

```xml
  <bean name="dept" class="com.example.Dept">
        <property name="name" value="滕王阁序"></property>
        <property name="empSet">
            <set>
                <ref bean="emp1"></ref>
                <ref bean="emp2"></ref>
                <ref bean="emp3"></ref>
            </set>
        </property>
    </bean>

    <bean name="emp1" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>

    <bean name="emp2" class="com.example.Emp">
        <property name="name" value="李四"></property>
    </bean>

    <bean name="emp3" class="com.example.Emp">
        <property name="name" value="王五"></property>
    </bean>
```

#### 方式三：抽取公共set

```xml
    <bean name="dept" class="com.example.Dept">
        <property name="empSet" ref="commonSet"></property>
    </bean>

    <util:set id="commonSet">
        <bean name="emp1" class="com.example.Emp">
            <property name="name" value="张三"></property>
        </bean>
        <bean name="emp2" class="com.example.Emp">
            <property name="name" value="李四"></property>
        </bean>
        <bean name="emp3" class="com.example.Emp">
            <property name="name" value="王五"></property>
        </bean>
    </util:set>
```



### DI 注入map 属性

```java
public class Dept {
 
   private Map<String,Object> empMap;
//省略set方法
}
```



#### 方式一：map标签+外部bean

```xml
 <bean name="dept" class="com.example.Dept">
        <property name="empMap">
            <map>
                <entry key="emp1" value-ref="emp1"></entry>
                <entry key="emp2" value-ref="emp2"></entry>
                <entry key="emp3" value-ref="emp3"></entry>
            </map>
        </property>
    </bean>
    <bean name="emp1" class="com.example.Emp">
        <property name="name" value="张三"></property>
    </bean>

    <bean name="emp2" class="com.example.Emp">
        <property name="name" value="李四"></property>
    </bean>

    <bean name="emp3" class="com.example.Emp">
        <property name="name" value="王五"></property>
    </bean>
```

#### 方式二：map标签+内部bean

```xml
 <bean name="dept" class="com.example.Dept">
        <property name="empMap">
            <map>
                <entry key="emp1">
                    <bean name="emp1" class="com.example.Emp">
                        <property name="name" value="张三"></property>
                    </bean>
                </entry>
                <entry key="emp2">
                    <bean name="emp1" class="com.example.Emp">
                        <property name="name" value="张三"></property>
                    </bean>
                </entry>
                <entry key="emp3">
                    <bean name="emp3" class="com.example.Emp">
                        <property name="name" value="王五"></property>
                    </bean>
                </entry>
            </map>
        </property>
    </bean>
```

#### 方式三：抽取公共map

```xml
 <util:map id="commonMap">
            <entry key="emp1">
                <bean name="emp1" class="com.example.Emp">
                    <property name="name" value="张三"></property>
                </bean>
            </entry>
            <entry key="emp2">
                <bean name="emp1" class="com.example.Emp">
                    <property name="name" value="张三"></property>
                </bean>
            </entry>
            <entry key="emp3">
                <bean name="emp3" class="com.example.Emp">
                    <property name="name" value="王五"></property>
                </bean>
            </entry>
    </util:map>
    <bean name="dept" class="com.example.Dept">
        <property name="empMap" ref="commonMap"></property>
    </bean>
```

















