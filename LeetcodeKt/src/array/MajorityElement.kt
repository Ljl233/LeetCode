package array

/*
面试题 17.10. 主要元素
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：

输入：[1,2,5,9,5,9,5,5,5]
输出：5


示例 2：

输入：[3,2]
输出：-1


示例 3：

输入：[2,2,1,1,1,2,2]
输出：2

 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val size = nums.size
        val map = HashMap<Int, Int>()
        nums.forEach {
            var value = map.get(it)
            if (value == null) value = 0
            map.put(it, value + 1)
        }
        map.keys.forEach { key ->
            if (map.get(key)!! > size / 2) return key
        }
        return -1
    }
}