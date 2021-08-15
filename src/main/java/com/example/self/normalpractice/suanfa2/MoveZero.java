package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-07-30 15:06
 */
public class MoveZero {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * [1,0,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{1,3,12,0,0};
        moveZero2(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void moveZero2(int[] nums){
        for (int i = 0, j = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num != 0){
                swap(nums, j , i);
                j ++;
            }

        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void moveZero(int[] nums){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num != 0){
                nums[j] = nums[i];
                j ++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


}
