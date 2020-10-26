package array

/*
1365. 有多少小于当前数字的数字
https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
class SmallerNumbersThanCurrent {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val clone = nums.clone()
        clone.sort()
        val res = IntArray(nums.size)

        var i = 0
        nums.forEach { num ->
            res[i++] = clone.indexOf(num)
        }
        return res
    }
}