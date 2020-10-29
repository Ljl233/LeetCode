package array
/*
#122. 买卖股票的最佳时机 II
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var res = 0
        for (i in 0 until prices.size - 1) {
            if (prices[i] < prices[i + 1]){
                res += prices[i+1] - prices[i]
            }
        }
        return res
    }
}