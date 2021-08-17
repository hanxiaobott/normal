package com.example.self.normalpractice.suanfa2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-16 18:09
 */
public class MultiThreadPrint {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                System.out.println("foo");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }

        }).start();

        TimeUnit.SECONDS.sleep(5);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                System.out.println("bar");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

            }

        }).start();
    }


}
