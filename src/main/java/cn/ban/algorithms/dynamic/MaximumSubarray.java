package cn.ban.algorithms.dynamic;

/**
 * leetcode53
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author banzijian
 * @date 2018/11/29
 **/
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            if (sum > maxSum)
                maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
