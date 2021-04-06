package com.example.self.normalpractice.suanfa.week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三数之和
 * @author: hanxiaobo
 * @create: 2021-04-06 12:46
 */
public class ThreeNumCount {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);

    }

    /**
     * 双指针夹逼 时间复杂是n²
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                return result;
            }

            for (int j = i + 1, k = nums.length -1 ; j < k ;) {
                int temp = nums[i] + nums[k] + nums[j];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while ( j < k && nums[j] == nums[j+1]){
                        j ++;
                    }
                    j++ ;
                    while (j < k && nums[k] == nums[k-1]){
                        k -- ;
                    }
                    k--;

                }else if(temp < 0){
                    j ++;
                }else {
                    k --;
                }
            }

            while (i < nums.length -1  && nums[i] == nums[i+ 1] ){
                i++;
            }
        }
        return result;
    }

}
