package dynamicprogramming;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] d = new int[n + 1];
        d[1] = 1;
        if (n >= 2)
            d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        return d[n];
    }
}
