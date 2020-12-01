package binarysearch
/*
34. 在排序数组中查找元素的第一个和最后一个位置
 */
class SearchRange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val leftIndex = binarySearch(nums, target, true)
        val rightIndex = binarySearch(nums, target, false) - 1

        if (leftIndex >= 0 && rightIndex < nums.size && leftIndex <= rightIndex && nums[leftIndex] == target && nums[rightIndex] == target) {
            return intArrayOf(leftIndex, rightIndex)
        }
        return intArrayOf(-1, -1)
    }

    fun binarySearch(nums: IntArray, target: Int, lower: Boolean): Int {
        var left = 0
        var right = nums.size - 1
        var ans = nums.size
        while (left < right) {
            val mid = (left + right) / 2
            if (target < nums[mid] || lower && target <= nums[mid]) {
                right = mid - 1
                ans = mid
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}
/*
fun searchRange(nums: IntArray, target: Int): IntArray {
        val targetRange = intArrayOf(-1, -1)

        val leftIndex = getIndex(nums, target, true)

        // 如果越界了或者值对不上，就返回 -1 -1
        if (leftIndex == nums.size || nums[leftIndex] != target) {
            return targetRange
        }

        //成功找到了左边界
        targetRange[0] = leftIndex
        // 有左一定有右
        targetRange[1] = getIndex(nums, target, false) - 1

        return targetRange

    }

    /**
     * 返回左右索引值
     * @param nums 数组
     * @param target 目标值
     * @param flag flag为true时递归查询左区间，flag为false时递归查询右区间
     * @return
     */
    fun getIndex(nums: IntArray, target: Int, flag: Boolean): Int {
        var left = 0
        var right = nums.size

        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > target || flag && nums[mid] == target) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
 */