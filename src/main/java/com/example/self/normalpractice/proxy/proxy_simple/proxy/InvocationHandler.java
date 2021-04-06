package com.example.self.normalpractice.proxy.proxy_simple.proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args);

}