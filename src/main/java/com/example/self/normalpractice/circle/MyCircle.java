package com.example.self.normalpractice.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-05-14 14:08
 */
@Service
public class MyCircle {

    @Autowired
    private MyLoop myLoop;

    public void test(){
        myLoop.testTest();
        System.out.println("11111");
    }

}
