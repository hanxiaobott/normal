package com.example.self.normalpractice.suanfa.week01;

/**
 * @description: 爬楼梯
 * @author: hanxiaobo
 * @create: 2021-04-06 12:39
 */
public class Elevetor {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param args
     */
    public static void main(String[] args) {
        int handle = handle(4);
        System.out.println(handle);
    }

    public static int handle(int a){
        if(a == 1 || a == 2 || a == 3){
            return a;
        }
        int b = 2;
        int c  = 3;
        int result = 0 ;
        for (int i = 3; i < a; i++) {
            result = b + c;
            b = c;
            c = result;
        }
        return result;
    }

}
