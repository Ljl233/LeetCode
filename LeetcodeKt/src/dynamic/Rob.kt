package dynamic

/*
#198. 打家劫舍
 */
class Rob {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]
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