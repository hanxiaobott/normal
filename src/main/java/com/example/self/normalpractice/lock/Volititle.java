package com.example.self.normalpractice.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-04-27 15:46
 */
public class Volititle {

    private static boolean flag = false;

    /**
     * 如果falg不加volatile关键字，那么下边的输出永远不会执行
     * @param args
     */
//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                flag = true;
//            }).start();
//        };
//        while (true){
//            if(flag){
//                System.out.println("------");
//            }
//        }
//    }


    private static volatile Integer num = 0;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(20000);
        for (int i = 0; i < 20000; i++) {
            new Thread(() -> {
                num = num + 1;
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(num);
    }
}
