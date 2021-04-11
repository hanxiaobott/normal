package com.example.self.normalpractice.suanfa.week02;

import java.util.PriorityQueue;

/**
 * @description:最小的k个数
 * @author: hanxiaobo
 * @create: 2021-04-11 17:57
 */
public class MinKNum {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {3,2,1};
        getLeastNumbers(arr, 2);

    }

    /**
     * 时间复杂度是nLogk,本身插入操作是lognk(这个k代表的是我只维护前k个数),插入了n次，那就是nlogk
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[k];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = queue.poll();
        }

        return ints;
    }
}
