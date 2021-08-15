package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-03 09:49
 */
public class RemoveArrayChongfu {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 双指针
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 4, 4, 4, 5};
        int i = removeDuplicates(ints);
        System.out.println(i);
        for (int j = 0; j < ints.length; j++) {
            System.out.println(ints[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j -1] && i != j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j ++;
            }

        }

        return j;
    }
}
