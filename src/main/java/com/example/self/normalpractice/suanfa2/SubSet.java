package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-06 17:40
 */
public class SubSet {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        subsets1(nums, 0 , result, Lists.newArrayList());
        return result;
    }

    /**
     * 递归
     * @param nums
     * @param level
     * @param result
     * @param current
     */
    public static void subsets1(int[] nums, int level, List<List<Integer>> result, List<Integer> current){
        if(level == nums.length ){
            result.add(current);
            return ;
        }

        // 不加当前level的值
        List<Integer> temp1 = Lists.newArrayList(current);

        subsets1(nums, level + 1, result, temp1);

        // 加上当前leveel的值
        ArrayList<Integer> temp2 = Lists.newArrayList(current);
        temp2.add(nums[level]);

        subsets1(nums, level + 1, result, temp2);

    }



}
