package math

/*
LCP 06. 拿硬币
 */
class MinCoins {
    fun minCount(coins: IntArray): Int {
        var ans = 0
        coins.forEach { coin->
            ans+=(coin+1)/2
        }
        return ans
    }
}