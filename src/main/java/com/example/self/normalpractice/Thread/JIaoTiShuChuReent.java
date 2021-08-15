package com.example.self.normalpractice.Thread;

import com.example.self.normalpractice.lock.ReentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 交替输出数字字母
 * @author: hanxiaobo
 * @create: 2021-04-28 09:46
 */
public class JIaoTiShuChuReent {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                lock.lock();
                System.out.print(i);
                condition2.signal();
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        new Thread(()->{
            for (int i = 1; i <= 26; i++) {
                lock.lock();
                System.out.print((char)(i+64));
                condition1.signal();
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

            }
        }).start();
    }
}
