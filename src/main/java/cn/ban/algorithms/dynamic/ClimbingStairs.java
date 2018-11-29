package cn.ban.algorithms.dynamic;

/**
 * leetcode70
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * @author banzijian
 * @date 2018/11/29
 **/
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = b;
            b += a;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
