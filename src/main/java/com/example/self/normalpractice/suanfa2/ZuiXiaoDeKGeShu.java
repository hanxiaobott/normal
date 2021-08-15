package com.example.self.normalpractice.suanfa2;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-04 18:19
 */
public class ZuiXiaoDeKGeShu {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 优先队列
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4,5,6,2,7,3};
        int[] leastNumbers = getLeastNumbers(nums, 2);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b-a));
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            Integer peek = queue.poll();
            queue.add(peek >= arr[i] ? arr[i] : peek);
        }

        int[] ints = new int[k];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = queue.poll();
        }
        return ints;
    }
}
