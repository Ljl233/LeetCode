package dynamic

/*
#70.爬楼梯
 */
class ClimbStairs {
    fun climbStairs(n: Int): Int {
        if (n < 3) return n
        var p = 1
        var q = 2
        var r = 3
        for (i in 3 until n) {
            p = q
            q = r
            r = p + q
        }
        return r
    }
}

fun main() {
    ClimbStairs().climbStairs(45).let(::println)
}