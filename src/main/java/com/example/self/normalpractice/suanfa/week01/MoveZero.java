package com.example.self.normalpractice.suanfa.week01;

/**
 * @description: 移动零
 * @author: hanxiaobo
 * @create: 2021-04-06 10:27
 */
public class MoveZero {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {0,1,0,3,2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        move(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static void move(int a[]){
        for (int i = 0, j = i + 1; i < a.length && j < a.length;) {
            if(a[i] == 0 && a[j] != 0){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i ++ ;
            }
            j ++ ;
        }
    }

}
