package com.example.self.normalpractice.proxy.cglib;

import com.example.self.normalpractice.proxy.jdk.UserMapper2;
import com.example.self.normalpractice.proxy.proxy_simple.model.User;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-25 15:35
 */
public class UserMapperImpl {

    public Integer save(User user) {
        System.out.println("实体类中的save方法执行");
        return 1;
    }

    public User getUserById(Integer id) {
        System.out.println("实体类中的get方法执行");
        return null;
    }

    final public Integer delete(Integer id) {
        System.out.println("实体类中的delete方法执行");
        return 2;
    }
}
