package cn.ban.algorithms.dynamic;

/**
 * leetcode121
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 *
 * @author banzijian
 * @date 2018/11/29
 **/
public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else
                profit = prices[i] - min;
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 8, 9, 1, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
