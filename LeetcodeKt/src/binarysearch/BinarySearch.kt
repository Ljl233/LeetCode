package binarysearch

/*
二分查找题解 by labuladong
https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/
 */
class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {

        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val mid = (l + r) / 2

            if (nums[mid] == target) return mid

            if (nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return -1
    }
}

fun main() {
    val array = intArrayOf(0, 1, 2, 3, 4, 6)
    val o = BinarySearch()
    println(o.search(array, 2))
}

/*
1. r = nums.size

==>
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size

        while (l < r) {
            val mid = (l + r) / 2

            if (nums[mid] == target) return mid

            if (nums[mid] > target) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return -1
    }

 */

/*
2. r = nums.size - 1
==>
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val mid = (l + r) / 2

            if (nums[mid] == target) return mid

            if (nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return -1
    }
 */