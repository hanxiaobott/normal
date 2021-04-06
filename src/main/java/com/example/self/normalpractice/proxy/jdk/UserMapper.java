package com.example.self.normalpractice.proxy.jdk;


import com.example.self.normalpractice.proxy.proxy_simple.model.User;

public interface UserMapper {

    Integer save(User user);

    User getUserById(Integer id);

    Integer delete(Integer id);
}
