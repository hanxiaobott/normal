package com.example.self.normalpractice.suanfa2;

import java.util.ArrayList;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-08-15 10:27
 */
public class MaxProfile {

    /**
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
    }

    public static int maxProfit(int[] prices) {
        if(prices.length <= 1 ){
            return 0;
        }
        // 第一维表示第几天，第二维度
        // 0，当前不持有股票，昨天不持股，不动，昨天持股，卖出
        // 1, 当前持有股票 ，昨天不持股，买入，昨天持股，不动
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[0][0]-prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][0];

    }
}
