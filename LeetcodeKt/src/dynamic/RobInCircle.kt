package dynamic

import java.util.*

/*
#213. 打家劫舍 II
 */
class RobInCircle {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
        return Math.max(myRob(nums.copyOfRange(0, nums.size - 1)), myRob(nums.copyOfRange(1, nums.size)))
    }

    private fun myRob(nums: IntArray): Int {
        var p = 0
        var q = 0

        for (element in nums) {
            val r = Math.max(q, p + element)
            p = q
            q = r
        }
        return q
    }

}