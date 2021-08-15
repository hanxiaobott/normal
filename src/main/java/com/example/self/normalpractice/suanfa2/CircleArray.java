package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-03 10:20
 */
public class CircleArray {

    /**旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        for (int j = 0; j < ints.length; j++) {
            System.out.print(ints[j] + "->");
        }

        circleArray2(ints, 3);
        System.out.println();

        for (int j = 0; j < ints.length; j++) {
            System.out.print(ints[j]+ "->");
        }
    }

    /**
     * 第二种思路是三次翻转
     * @param nums
     * @param k
     */
    public static void circleArray2(int[] nums, int k){

        //翻转整个数组
        reverse(nums, 0 ,nums.length -1);

        // 翻转前半部分
        reverse(nums,0, k-1);

        // 翻转后半部分
        reverse(nums,k, nums.length -1);

    }

    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++ ;
            end --;
        }

    }


    /**
     * 第一种思路是最后一个元素和每一个元素替换，从后往前替换，第一次替换完以后，变成了
     * 7,1,2,3,4,5,6
     * 第二次变成了
     * 6,7,1,2,3,4,5
     * 第三次变成了
     * 5,6,7,1,2,3,4
     * @param nums
     * @param k
     */
    public static void circleArray(int[] nums, int k) {

        for (int i = 1; i <= k ; i++) {
            int temp = nums.length- 1;
            for (int j = temp - 1; j >= 0 ; j --) {
                swap(nums, temp, j );
                temp --;
            }
        }

    }

    public static void swap(int[] nums, int i ,int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
