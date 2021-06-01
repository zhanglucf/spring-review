package com.example;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class DemoTest {

    @Test
    public void method3() {
        final UserService userService = new UserServiceImpl();
        final UserService proxyInstance = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new UserServiceProxy(userService));
        proxyInstance.insertUser();
        proxyInstance.updateUser();
        proxyInstance.findUser();
        proxyInstance.deleteUser();
    }

}
