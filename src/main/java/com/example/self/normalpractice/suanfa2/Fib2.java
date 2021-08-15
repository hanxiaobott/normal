package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-11 09:10
 */
public class Fib2 {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static Integer fib(int n){
        if(n ==1 || n == 2){
            return 1;
        }

        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i-1]+ array[i-2];
        }

        return array[n-1];

    }
}
