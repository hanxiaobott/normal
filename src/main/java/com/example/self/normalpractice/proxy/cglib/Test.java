package com.example.self.normalpractice.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-25 10:01
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/hanxiaobo/Downloads/proxyproxyproxy");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserMapperImpl.class);
        enhancer.setCallback(new SelfCallBack());
        UserMapperImpl userMapper = (UserMapperImpl)enhancer.create();
        userMapper.delete(1);
        userMapper.save(null);
    }
}
