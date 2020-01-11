package dynamicprogramming;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int account = 0;
        int m = 0, t = 0;
        for (int i = 0; i < prices.length; i++) {
            if (m != 0 && prices[i] < prices[i + 1]) {
                m = prices[i];
            }

            if (prices[i] > prices[i + 1] && m != 0) {
                t = prices[i];
                account += t - m;
            }
        }
        return 0;
    }
}
