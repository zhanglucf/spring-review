

### 通知的执行顺序

#### 只有一个切面时

<font color='orange'>正常场景中</font>：

1. around before
2. before
3. target method
4. around after
5. after
6. afterReturning

![image-20210530132542544](E:\spring\image-20210530132542544.png)

<font color='red'>异常场景中</font>：

1. around before
2. before
3. target method
4. after
5. AfterThrowing

![image-20210530133139675](E:\spring\10-spring-demo\image-20210530133139675.png)

#### 多个切面时

> 可以通过@Order注解指定顺序，Order值越小，越先执行

<font color='orange'>正常场景中</font>：

1. <font color='orange'>advice-1 around before</font> 
2. <font color='orange'>advice-1 before</font>
3. advice-2 around before
4. advice-2 before
5. target method
6. advice-2 around after
7. advice-2 after
8. advice-2 afterReturning
9. <font color='orange'>advice-1 around after</font>
10. <font color='orange'>advice-1 after</font>
11. <font color='orange'>advice-1 afterReturning</font>

![image-20210530141105958](E:\spring\10-spring-demo\image-20210530141105958.png)

<font color='red'>异常场景中</font>：

1. <font color='orange'>advice-1 around before</font>
2. <font color='orange'>advice-1 before</font>
3. advice-2 around before
4. advice-2 before
5. target method
6. advice-2 after
7. advice-2 AfterThrowing
8. <font color='orange'>advice-1 after</font>
9. <font color='orange'>advice-1 afterThrowing</font>

![image-20210530140158062](E:\spring\10-spring-demo\image-20210530140158062.png)

下一节，重点研究`通知`中如何获取请求参数

