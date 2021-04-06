package com.example.self.normalpractice.suanfa.week01;

/**
 * @description: 加1
 * @author: hanxiaobo
 * @create: 2021-04-06 11:22
 */
public class AddOne {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {1,2,3};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        handle(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static void handle(int a[]){
        for (int i = a.length -1 ; i >= 0; i++) {
            a[i] = a[i] + 1;
            if(a[i] != 0){
                return;
            }
        }
        a = new int[a.length +1 ];
        a[0] = 1;
    }
}
