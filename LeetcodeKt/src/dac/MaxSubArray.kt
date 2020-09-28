package dac

/*
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 */

class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var i = 0
        val size = nums.size
        var max = nums[0]
        var temp = 0
        while (i < size) {
            if (temp < 0) temp = 0
            temp += nums[i]
            max = Math.max(max, temp)
            i++
        }
        return max
    }

    fun maxSubArrayDAC(nums: IntArray): Int {
        return getInfo(nums, 0, nums.size - 1).mSum
    }

    class Status(var lSum: Int, var rSum: Int, var mSum: Int, var iSum: Int)

    fun getInfo(nums: IntArray, l: Int, r: Int): Status {
        if (l == r) return Status(nums[l], nums[l], nums[l], nums[l])

        val lSub = getInfo(nums, l, (l + r) / 2)
        val rSub = getInfo(nums, (l + r) / 2, r)
        return pushUp(lSub, rSub)
    }

    private fun pushUp(l: MaxSubArray.Status, r: MaxSubArray.Status): MaxSubArray.Status {
        val iSum = l.iSum + r.iSum
        val lSum = Math.max(l.lSum, l.iSum + l.lSum)
        val rSum = Math.max(r.rSum, r.iSum + l.rSum)
        val mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum)

        return Status(lSum, rSum, mSum, iSum)
    }
}