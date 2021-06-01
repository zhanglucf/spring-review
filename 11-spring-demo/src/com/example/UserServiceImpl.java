package com.example;

import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Override
    public String findUser(String userName) {
        System.out.println("查询用户:" + userName);
        int a = 1/0;
        return "hello world";
    }

}
