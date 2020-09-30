package array

/*
1512. 好数对的数目
给你一个整数数组 nums 。

如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

返回好数对的数目。



示例 1：

输入：nums = [1,2,3,1,1,3]
输出：4
解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
示例 2：

输入：nums = [1,1,1,1]
输出：6
解释：数组中的每组数字都是好数对
示例 3：

输入：nums = [1,2,3]
输出：0


提示：

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */
class NumIdenticalPairs {
    fun numIdenticalPairs(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        nums.forEach { num ->
            map.set(num, map.getOrDefault(num, 0) + 1)
        }

        var ans = 0
        map.entries.forEach { entry ->
            val value = entry.value
            ans += value * (value - 1) / 2
        }
        return ans
    }
}