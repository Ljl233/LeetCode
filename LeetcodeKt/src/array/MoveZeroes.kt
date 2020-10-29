package array

/*
#283. 移动零
https://leetcode-cn.com/problems/move-zeroes/
 */
class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var slow = 0
        var quick = 0
        while (quick < nums.size) {
            when {
                nums[quick] == 0 -> {
                    quick++
                }
                quick == slow -> {
                    quick++
                    slow++
                }
                else -> {
                    nums[slow] = nums[quick]
                    quick++
                    slow++
                }
            }

        }
        while (slow < nums.size) {
            nums[slow] = 0
            slow++
        }
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    MoveZeroes().moveZeroes(nums)
}