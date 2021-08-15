package com.example.self.normalpractice.ThreadLoacl;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:fengyuhao
 * @Email: fengyuhao@xdf.cn
 * @Version: 1.0
 * @Date: 2019/04/12 16:07
 * @Description: TODO
 **/
public class ContextEnv {

    public static ThreadLocal<String> email = new ThreadLocal<>();
    public static ThreadLocal<String> tel =  new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        InheritableThreadLocal<String> parent = new InheritableThreadLocal<>();
        ThreadLocal<String> child = new ThreadLocal<>();
        child.set("2222");
        parent.set("1111");

        Thread thread = Thread.currentThread();
        System.out.println(child.get());
        System.out.println(parent.get());
        TimeUnit.SECONDS.sleep(5);

        new Thread(()->{
            System.out.println(child.get());
            System.out.println(parent.get());
        }).start();

    }
}
