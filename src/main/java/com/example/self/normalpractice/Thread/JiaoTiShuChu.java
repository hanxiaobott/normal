package com.example.self.normalpractice.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 交替输出数字字母
 * @author: hanxiaobo
 * @create: 2021-04-27 16:20
 */
public class JiaoTiShuChu {

    /**
     * 也可以不用countdownlauch，定义变量即可
     * @param args
     * @throws InterruptedException
     */
//    public static void main(String[] args) throws InterruptedException {
//        Object object = new Object();
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        new Thread(()->{
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (object){
//                for (int i = 1; i <= 26; i++) {
//                    System.out.println(i);
//                    object.notify();
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                object.notify();
//            }
//            System.out.println("执行完了1");
//
//        }).start();
//        new Thread(()->{
//            synchronized (object){
//                countDownLatch.countDown();
//                for (int i = 1; i <= 26; i++) {
//                    System.out.println((char)(i+64));
//                    object.notify();
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                object.notify();
//            }
//            System.out.println("执行完了2");
//
//        }).start();
//    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        Object object = new Object();
        new Thread(()->{
            while (a.flag){

            }
            synchronized (object){
                for (int i = 1; i <= 26; i++) {
                    System.out.println(i);
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
            System.out.println("执行完了1");

        }).start();
        new Thread(()->{
            synchronized (object){
                a.flag = false;
                for (int i = 1; i <= 26; i++) {
                    System.out.println((char)(i+64));
                    object.notify();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                object.notify();
            }
            System.out.println("执行完了2");

        }).start();
    }

    public static class A{
        private volatile Boolean flag = true;
    }

}

