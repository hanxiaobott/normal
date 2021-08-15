package com.example.self.normalpractice.suanfa2;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-10 09:16
 */
public class UniquePaths {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/2AoeFn
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 动态规划
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }

    public static int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];
        for (int i = m - 1; i >= 0; i-- ) {
            for (int j = n -1 ; j >= 0; j --) {
                if(i == m -1 || j == n -1){
                    array[i][j] = 1;
                }else {
                    array[i][j] = array[i + 1][j] + array[i][j + 1];
                }
            }
        }

        return array[0][0];

    }
}
