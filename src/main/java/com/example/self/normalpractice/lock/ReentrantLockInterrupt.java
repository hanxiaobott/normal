package com.example.self.normalpractice.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-07-15 10:06
 */
public class ReentrantLockInterrupt {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程开始执行");
            System.out.println(Thread.currentThread().isInterrupted());
            try {
                TimeUnit.SECONDS.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().isInterrupted());
        });

        thread.interrupt();
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
        System.out.println(thread.isInterrupted());

        ReentrantLock lock = new ReentrantLock();
//        lock.tryLock(1,TimeUnit.SECONDS)
    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            lock();
//        });
//
//        thread.setName("优秀");
//        thread.start();
//        TimeUnit.SECONDS.sleep(3);
//        thread.interrupt();
//
//        Thread thread1 = new Thread(() -> {
//            lock();
//        });
//        thread1.setName("不");
//        thread1.start();
//    }
//
//    public synchronized static void lock(){
//        System.out.println("获取到锁");
//        if(Thread.currentThread().getName().equals("优秀")){
//            try {
//                Thread.currentThread().wait();
//            } catch (InterruptedException e) {
//            }
//        }
//        for (int i = 0; i < 2000000; i++) {
//            System.out.println(i+"__"+Thread.currentThread().getName());
//        }
//        System.out.println("end");
//    }
//    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            try {
//                method();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("t1执行完了");
//        }, "t1");
//        t1.start();
//
//        TimeUnit.SECONDS.sleep(1);
//
//        Thread t2 = new Thread(() -> {
//            try {
//                method();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("t2执行完了");
//
//        }, "t2");
//        t2.start();
//        TimeUnit.SECONDS.sleep(2);
//
//        Thread t3 = new Thread(() -> {
//            try {
//                method();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("t3执行完了");
//
//        }, "t3");
//        t3.start();
//        TimeUnit.SECONDS.sleep(2);
//        t3.interrupt();
//
//    }

//    public static void main(String[] args) {
//        Thread thread = new Thread(() -> {
//            LockSupport.park();
//            System.out.println("1111");
//            Thread.interrupted();
//            LockSupport.park();
//            System.out.println("2222");
//            LockSupport.park();
//            System.out.println("3333");
//
//        });
//        thread.start();
//        thread.interrupt();
//    }

    public static void method() throws InterruptedException {
//        lock.lock();
        lock.lockInterruptibly();
        String name = Thread.currentThread().getName();
        System.out.println(name);
        if(name.equals("t1")){
            TimeUnit.SECONDS.sleep(10);
        }
        if(name.equals("t2")){
            TimeUnit.SECONDS.sleep(10);
        }
        lock.unlock();
    }
}
