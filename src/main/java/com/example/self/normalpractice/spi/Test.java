package com.example.self.normalpractice.spi;

import java.util.ServiceLoader;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-05-12 09:28
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<IService> loader = ServiceLoader.load(IService.class);
        for (IService service : loader) {
            service.doSomeThing();
        }
    }
}
