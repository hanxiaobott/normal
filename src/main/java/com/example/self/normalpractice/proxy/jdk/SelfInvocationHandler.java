package com.example.self.normalpractice.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-25 10:10
 */
public class SelfInvocationHandler implements InvocationHandler {

    private Object object;

    public SelfInvocationHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("方法执行之前");
        Object invoke = null;
        try {
            invoke = method.invoke(object, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("方法执行之后");
        return invoke;
    }
}
