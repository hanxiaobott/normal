package com.example.self.normalpractice.suanfa.week01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 俩数之和
 * @author: hanxiaobo
 * @create: 2021-04-06 11:28
 */
public class TwoNumAdd {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {2,7,11,15};
        int[] b = handle(a, 9);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
        }


    }

    /**
     * 时间复杂度是n
     * @param a
     * @param target
     * @return
     */
    public  static  int[] handle(int a[], int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Integer temp = map.get((target - a[i]));
            if( temp != null){
                int result[] = {temp, i};
                return  result;
            }
            map.put(a[i] , i);
        }

        return null;
    }

    /**
     * 时间复杂度是logn,因为有sort，sort的复杂度大(这种思路适用于三数之和)
     * @param a
     * @param target
     * @return
     */
    public static int[] handle1(int a[], int target){
        Arrays.sort(a);
        int result[] = new int[2];
        for (int i = 0, j = a.length -1 ; i < a.length && i < j;) {
            if(target < a[i]){
                return result;
            }
            if(a[i] + a[j] == target){
                result[0] = a[i];
                result[1] = a[j];
            }else if(a[i] + a[j] > target){
                j --;
            }else {
                i ++;
            }
        }
        return result;
    }
}
