package array

import java.util.*
import kotlin.collections.HashMap

/*
#350. 两个数组的交集 II
https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
class Intersect {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.size > nums2.size) return intersect(nums2, nums1)

        val map = HashMap<Int, Int>()
        for (num in nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        val res = IntArray(nums1.size)

        var index = 0
        nums2.forEach { num ->
            var count = map.getOrDefault(num, 0)
            if (count > 0) {
                res[index++] = num
                count--
                if (count > 0) {
                    map.put(num, count)
                } else {
                    map.remove(num)
                }
            }
        }
        return res.copyOfRange(0, index)
    }
}