package math

/*
LCP 06. 拿硬币
 */
class PickCoins {
    fun minCount(coins: IntArray): Int {
        var res = 0
        coins.forEach {
            res += (it + 1) / 2
        }
        return res
    }
}