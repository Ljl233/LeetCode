package array

import java.util.*

/*
164. 最大间距
 */
class MaximumGap {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) return 0
//        nums.sort()
        radixSort(nums)
        var max = 0
        var i = 1
        while (i < nums.size) {
            max = Math.max(max, nums[i] - nums[i - 1])
            i++
        }
        return max
    }
}

fun radixSort(nums: IntArray) {
    val n = nums.size
    var exp = 1L
    val buf = IntArray(n)

    val max = Arrays.stream(nums).max().asInt
    while (max >= exp) {
        val cnt = IntArray(10)
        nums.forEach { num ->
            val digit = (num / exp.toInt()) % 10
            cnt[digit]++
        }

        for (i in 1..9) {
            cnt[i] += cnt[i - 1]
        }

        for (i in n - 1 downTo 0) {
            val digit = (nums[i] / exp.toInt()) % 10
            buf[cnt[digit] - 1] = nums[i]
            cnt[digit]--
        }
        System.arraycopy(buf, 0, nums, 0, n)

        exp *= 10
    }

}

fun main() {
    val s = intArrayOf(2, 4, 4, 7, 3, 1)
    s.forEach(::println)
}