package com.example;

import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl  implements UserService {

    @Override
    public void insertUser() {
        System.out.println("添加用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");

    }

    @Override
    public void findUser() {
        System.out.println("查询用户");

    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
