package array

/*
#136. 只出现一次的数字
https://leetcode-cn.com/problems/single-number/
 */
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var res = 0
        nums.forEach { num ->
            res = res xor num
        }
        return res
    }
}