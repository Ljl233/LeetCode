package athority;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //自下而上
        int max = amount + 1;
        int[] count = new int[amount + 1];
        Arrays.fill(count, max);
        count[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int j = 0; i < coins.length; i++) {
                count[i] = Math.min(count[i - coins[j]] + 1, count[i]);
            }
        return count[amount] > amount ? -1 : count[amount];
    }
}

/*
    从上往下回溯
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        int min = Integer.MAX_VALUE;
        if (count[rem - 1] != 0) return count[rem - 1];
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }
 */