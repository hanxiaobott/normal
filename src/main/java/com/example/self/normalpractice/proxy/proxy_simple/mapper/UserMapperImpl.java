package com.example.self.normalpractice.proxy.proxy_simple.mapper;

import com.example.self.normalpractice.proxy.proxy_simple.model.User;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 17:27
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public Integer save(User user) {
        System.out.println("111");
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        System.out.println("222");
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        System.out.println("333");
        return null;
    }
}
