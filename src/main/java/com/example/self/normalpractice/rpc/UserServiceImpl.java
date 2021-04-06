package com.example.self.normalpractice.rpc;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 10:39
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(int age){
        User user = new User();
        user.setAge(age);
        return user;
    }
}
