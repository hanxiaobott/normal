package com.example.self.normalpractice.spi;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-05-12 09:27
 */
public class DefalutService implements IService{

    @Override
    public void doSomeThing() {
        System.out.println("默认服务");
    }

}
