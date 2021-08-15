package com.example.self.normalpractice.Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-04-28 10:14
 */
public class Duck {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition offer = lock.newCondition();
        Condition poll = lock.newCondition();

        new Thread(()->{
            while (true){
                lock.lock();
                while (queue.size() == 10){
                    System.out.println("队列满了。不放了");
                    try {
                        offer.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("放进一个鸭子");
                queue.offer(1);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                poll.signal();
                lock.unlock();
            }

        }).start();

        new Thread(()->{
            while (true){
                lock.lock();
                while (queue.isEmpty()){
                    System.out.println("队列是空的");
                    try {
                        poll.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("取出一个鸭子");
                queue.poll();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                offer.signal();
                lock.unlock();
            }
        }).start();
    }
}
