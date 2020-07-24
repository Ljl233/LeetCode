package dynamicprogramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        f[0] = cost[0];
        f[1] = cost[1];
        for (int i = 2; i <= n; i++) {
            f[i] = cost[i] + Math.min(f[i - 1], f[i - 2]);
        }
        return Math.min(f[n - 1], f[n - 2]);
    }
}
