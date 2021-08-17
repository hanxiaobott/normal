package com.example.self.normalpractice.Thread.Thread2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-16 18:22
 */
public class JiaoTiShuChu {
    private static volatile boolean flag = true;

//    public static void main(String[] args) {
//        new Thread(()->{
//            for (int i = 1; i <= 26; i++) {
//                while (!flag){}
//                System.out.print(i);
//                flag = false;
//            }
//        }).start();
//
//        new Thread(()->{
//            for (int i = 1; i <= 26; i++) {
//                while (flag){}
//                System.out.print((char)(i+64));
//                flag = true;
//            }
//        }).start();
//
//    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();


    }


}
