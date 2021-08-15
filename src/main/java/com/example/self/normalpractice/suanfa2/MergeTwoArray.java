package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-03 18:02
 */
public class MergeTwoArray {

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
     * 这样它就有足够的空间保存来自 nums2 的元素。
     *
     * 从后开始遍历，最大的元素放在数组末尾
     * @param args
     */
    public static void main(String[] args) {
        int[] ints1 = {6,7,8,9,0,0,0};
        int[] ints2 = {2,5,6};
        merge(ints1,4,ints2,3);
        for (int j = 0; j < ints1.length; j++) {
            System.out.print(ints1[j] + "->");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n -1 ,tail = m + n - 1;
        for (; i > 0 && j > 0 ; ) {
            if(nums1[i] > nums2[j]){
                nums1[tail] = nums1[i];
                i --;
            }else if(nums1[i] < nums2[j]){
                nums1[tail] = nums2[j];
                j --;
            }else {
                nums1[tail] = nums1[i];
                tail --;
                nums1[tail] = nums2[j];
                i --;
                j --;
            }
        }

        for (; j >= 0 ; j --) {

        }
    }
}
