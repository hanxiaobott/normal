package com.example.self.normalpractice.suanfa.week01;

/**
 * @description: 盛水
 * @author: hanxiaobo
 * @create: 2021-04-06 11:40
 */
public class ContainWater {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(handle(a));
    }

    public static int handle(int[] height){
        int result = 0;
        for (int i = 0, j = height.length -1 ; i < height.length && i < j;) {
            result = Math.max ((j-i) * Math.min(height[i], height[j]), result);
            if(height[i] < height[j]){
                i ++ ;
            }else {
                j --;
            }
        }
        return result;
    }
}
