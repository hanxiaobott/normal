package com.example.self.normalpractice.spi;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-05-12 09:27
 */
public class LogService implements IService{

    @Override
    public void doSomeThing() {
        System.out.println("日志服务");
    }
}
