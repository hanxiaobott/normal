package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-05 15:45
 */
public class ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }

    public static int climbStairs(int a) {
        if(a <= 2){
            return a;
        }
        return climbStairs(a- 1) + climbStairs(a- 2);
    }

    public static int climbStairs1(int a) {
        if(a <= 2){
            return a;
        }
        int a1 = 1;
        int a2 = 2;
        for (int i = 2; i < a; i++) {
            int temp = a1 + a2;
            a1 = a2;
            a2 = temp;
        }
        return a2;
    }
}
