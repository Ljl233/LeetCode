package binarysearch

/*
69. x 的平方根
 */
class MySqrt {
    fun mySqrt(x: Int): Int {
        if (x <= 1) return x

        var l = 1L
        var r = x.toLong()

        while (l <= r) {
            val mid: Long = l + (r - l) / 2

            val mid2 = mid * mid
            if (mid2 == x.toLong()) return mid.toInt()
            else if (mid2 > x) {
                r = mid - 1
            } else if (mid2 < x) {
                l = mid + 1
            }
        }

        return l.toInt() - 1
    }
}

fun main() {
    val mySqrt = MySqrt()
    println(mySqrt.mySqrt(2147395599))
}

/* ==> 1.
    fun mySqrt(x: Int): Int {
        var l = 0
        var r = x
        var ans = -1
        while (l <= r) {
            val mid = l + (r - l) / 2

            val mid2: Long = mid.toLong() * mid
            if (mid2 <= x) {
                ans = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return ans
    }
 */