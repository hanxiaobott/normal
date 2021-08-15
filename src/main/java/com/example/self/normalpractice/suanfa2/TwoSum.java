package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-07-30 15:41
 */
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出
     * 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     */
    public static void main(String[] args) {
        int[] a = new int[]{1,5,4,9,0};
        int[] ints = twoSum(a, 10);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < a.length; i++) {
            int b = a[i];
            Integer value = map.get(target - b);
            if(value != null){
                int[] ints = new int[2];
                ints[0] = value;
                ints[1] = i;
                return ints;
            }
            map.put(b,i);
        }
        return null;
    }
}
