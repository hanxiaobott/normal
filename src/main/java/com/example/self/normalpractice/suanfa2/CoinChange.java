package com.example.self.normalpractice.suanfa2;

import java.util.Arrays;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-11 09:14
 */
public class CoinChange {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 你可以认为每种硬币的数量是无限的。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1,2,5};
        System.out.println(coinChange(ints, 11));

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount);
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            int temp = amount;
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    // 求最小值的过程
                    temp = Math.min(temp,dp[i - coins[j]]);
                }
            }
            // 最小值+1就是当前的
            dp[i] = temp + 1;
        }

        return dp[amount] > amount ? -1:dp[amount];

    }
}
