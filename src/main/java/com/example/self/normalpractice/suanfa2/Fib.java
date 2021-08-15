package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-10 09:11
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib1(5));
    }

    public static int fib(int n) {
        if(n == 1 || n == 2){
            return 1;
        }

        return fib(n- 1) + fib(n -2);
    }

    public static int fib1(int n) {
        if(n == 1 || n == 2){
            return 1;
        }

        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i -2];
        }
        return array[n - 1];
    }
}
