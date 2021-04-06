package com.example.self.normalpractice.proxy.jdk;

import com.example.self.normalpractice.proxy.proxy_simple.model.User;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-25 10:19
 */
public class UserMapperImpl implements  UserMapper,UserMapper2{
    @Override
    public Integer save(User user) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        System.out.println("真正的方法执行");
        return null;
    }

    @Override
    public void handle() {
        System.out.println("handle的方法执行");
    }
}
