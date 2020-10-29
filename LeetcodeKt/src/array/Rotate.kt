package array

/*
#189. 旋转数组
https://leetcode-cn.com/problems/rotate-array/
 */
class Rotate {
    fun rotate(nums: IntArray, k: Int): Unit {
        var i = 0
        var j = nums.size - k % nums.size

        while (i < k) {
            moveKthToStart(nums, j, i)
            j++
            i++
        }
    }

    fun moveKthToStart(nums: IntArray, k: Int, start: Int) {
        if (k >= nums.size) return
        val temp = nums[k]

        var i = k
        while (i > start) {
            nums[i] = nums[i - 1]
            i--
        }
        nums[start] = temp
    }
}

fun main() {
    val nums = intArrayOf(-1)
    Rotate().rotate(nums, 3)
}