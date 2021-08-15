package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-06 17:26
 */
public class Pow {

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(myPow(2,10));
    }

    /**
     * 思路，二分递归
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        if(n > 0){
            return myPow1(x, n);
        }else {
            return 1 / myPow1(x, 0-n);
        }
    }

    public static double myPow1(double x, int n){
        if(n == 1){
            return x;
        }

        if(n % 2 == 1){
            // 奇数
            double v = myPow1(x, n / 2);
            return v * v * x;

        }else{
            // 偶数
            double v = myPow1(x, n / 2);
            return v * v;
        }
    }

}
