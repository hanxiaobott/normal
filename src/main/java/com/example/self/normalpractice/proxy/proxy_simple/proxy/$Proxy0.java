package com.example.self.normalpractice.proxy.proxy_simple.proxy;

import java.lang.reflect.Method;

public class $Proxy0 implements com.example.self.normalpractice.proxy.proxy_simple.mapper.UserMapper {

    private InvocationHandler  handler;

    public $Proxy0(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public java.lang.Integer delete(java.lang.Integer param0) {
        try {
            Method method = com.example.self.normalpractice.proxy.proxy_simple.mapper.UserMapper.class.getDeclaredMethod("delete",java.lang.Integer.class);
            return (java.lang.Integer)handler.invoke(this, method, new Object[]{param0});
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public java.lang.Integer save(com.example.self.normalpractice.proxy.proxy_simple.model.User param0) {
        try {
            Method method = com.example.self.normalpractice.proxy.proxy_simple.mapper.UserMapper.class.getDeclaredMethod("save",com.example.self.normalpractice.proxy.proxy_simple.model.User.class);
            return (java.lang.Integer)handler.invoke(this, method, new Object[]{param0});
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public com.example.self.normalpractice.proxy.proxy_simple.model.User getUserById(java.lang.Integer param0) {
        try {
            Method method = com.example.self.normalpractice.proxy.proxy_simple.mapper.UserMapper.class.getDeclaredMethod("getUserById",java.lang.Integer.class);
            return (com.example.self.normalpractice.proxy.proxy_simple.model.User)handler.invoke(this, method, new Object[]{param0});
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}