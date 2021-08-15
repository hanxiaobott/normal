package com.example.self.normalpractice.suanfa2;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-06 17:57
 */
public class Combine {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * 输入：n = 4, k = 2
     * 输出：
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(combine(4, 2));

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> reuslt = Lists.newArrayList();
        method(reuslt, Lists.newArrayList(), n, k, 1);
        return reuslt;
    }

    public static void method(List<List<Integer>> result, List<Integer> current , int n, int k, int i){
        if(i == n + 1){
            if(current.size() == k){
                result.add(current);
            }
            return;
        }

        method(result, Lists.newArrayList(current), n, k, i + 1);

        ArrayList<Integer> copy = Lists.newArrayList(current);
        copy.add(i);
        method(result, Lists.newArrayList(copy), n, k, i + 1);
    }


}
