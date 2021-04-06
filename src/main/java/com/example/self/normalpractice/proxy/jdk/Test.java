package com.example.self.normalpractice.proxy.jdk;


import com.example.self.normalpractice.proxy.proxy_simple.model.User;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-25 10:09
 */
public class Test {
    public static void main(String[] args) {

        // 第二个参数需要的是当前被代理类的所有接口，所有实现接口，最终生成的代理类是包含这所有接口的方法的类，代理类实现了这多个接口，所以可以强转成为任意代理类
        // jdk的这种代理是需要目标代理类实现对应的接口的，只能代理对应接口中的方法，而cglib是不需要代理类实现对应的接口的
        // jdk生成的代理类是目标代理类实现所有接口的类，和目标代理类关系不大，而cglib生成的代理类是目标代理类的子类，和目标代理类是否实现接口没有关系
        UserMapper2 userMapper =(UserMapper2) Proxy.newProxyInstance(UserMapper.class.getClassLoader(),
                new Class[]{UserMapper.class,UserMapper2.class}, new SelfInvocationHandler(new UserMapperImpl()));
        userMapper.handle();
    }
}
