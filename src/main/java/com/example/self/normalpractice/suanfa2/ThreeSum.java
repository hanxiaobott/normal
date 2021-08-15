package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-07-30 17:29
 */
public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 4, -5, 4, 2};
        List<List<Integer>> lists = threeSum2(ints);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= Lists.newArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1,k = nums.length-1; j < k;) {
                if(nums[j] + nums[k] + nums[i] == 0){
                    List<Integer> single = Lists.newArrayList();
                    single.add(nums[j]);
                    single.add(nums[k]);
                    single.add(nums[i]);
                    result.add(single);
                    while (j < k && nums[j] == nums[j+1]){
                        j++;
                    }

                    while (j < k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }else if(nums[j] + nums[k] + nums[i] > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return result;
    }






    /**
     * 排序+双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>>  results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                return results;
            }

            for (int j = i+1,k = nums.length-1; j< k;j++,k--) {
                if(nums[j] + nums[k] + nums[i] == 0){
                    List<Integer> single = Lists.newArrayList();
                    single.add(nums[j]);
                    single.add(nums[k]);
                    single.add(nums[i]);
                    results.add(single);
                }

                while (j < k && nums[j] == nums[j+1] ){
                    j ++;
                }

                while (j < k && nums[k] == nums[k-1]){
                    k --;
                }

            }
        }

        return results;

    }

    /**
     * 转化为俩数之和，有重复
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  results = Lists.newArrayList();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Map<Integer, Integer> map = Maps.newHashMap();
            for (int j = i+1; j < nums.length; j++) {
                int num1 = nums[j];
                Integer integer = map.get(0 - num - num1);
                if(!Objects.isNull(integer)){
                    List<Integer> single = Lists.newArrayList();
                    single.add(num);
                    single.add(num1);
                    single.add(0-num-num1);
                    results.add(single);
                }
                map.put(num1,j);
            }
        }

        return results;
    }
}
