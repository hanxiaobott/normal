package com.example.self.normalpractice.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-25 10:02
 */
public class SelfCallBack implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理方法之前");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("代理方法之后");
        return invoke;
    }
}
