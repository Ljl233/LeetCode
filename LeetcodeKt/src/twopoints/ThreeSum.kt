package twopoints

/*15. 三数之和
 */

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        val n = nums.size
        nums.sort()
        for (first in nums.indices) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue
            }
            var third = n - 1
            val target = -nums[first]
            for (second in (first + 1) until n) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue
                }

                while (second < third && nums[second] + nums[third] > target) {
                    third--
                }

                if (second == third) {
                    break
                }
                if (nums[second] + nums[third] == target) {
                    val list = mutableListOf<Int>()
                    list.add(nums[first])
                    list.add(nums[second])
                    list.add(nums[third])
                    ans.add(list)
                }
            }
        }
        return ans
    }
}