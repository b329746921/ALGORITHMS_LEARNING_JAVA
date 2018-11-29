package cn.ban.algorithms.dynamic;

/**
 * leetcode198
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * @author banzijian
 * @date 2018/11/29
 **/
public class HouseRobber {
    public static int rob(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0)
            return 0;
        if (length == 1)
            return nums[0];
        int lastProfit = nums[0];
        int profit = Math.max(lastProfit, nums[1]);
        int temp;
        for (int i = 2; i < length; i++) {
            temp = profit;
            profit = Math.max(lastProfit + nums[i], profit);
            lastProfit = temp;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1, 4};
        System.out.println(rob(nums));
    }
}
