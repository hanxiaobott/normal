package com.example.self.normalpractice.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-04-26 16:19
 */
public class ReentrantLockTest {

    /**
     * 锁在超时后放弃等待，没有
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//        try {
//            lock.lock();
//            condition.await(5, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            System.out.println("出异常了。");
//            e.printStackTrace();
//        }
//        System.out.println("没出异常");
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            System.out.println("1等待");
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1唤醒");
            lock.unlock();

        }).start();
        new Thread(() -> {
            lock.lock();
            System.out.println("2等待");
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2唤醒");
            lock.unlock();
        }).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程获取锁");
        lock.lock();
        condition1.signalAll();
        condition2.signalAll();
        lock.unlock();
    }

}
