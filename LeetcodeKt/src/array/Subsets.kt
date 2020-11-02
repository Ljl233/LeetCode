package array

/*
#78. Subsets
https://leetcode-cn.com/problems/subsets/
 */
class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val tmp = mutableListOf<Int>()
        val res = mutableListOf<List<Int>>()

        val size = nums.size
        for (num in 0 until (1 shl size)) {
            tmp.clear()
            for (i in 0 until size) {
                if ((num and (1 shl i)) != 0) {
                    tmp.add(nums[i])
                }
            }
            res.add(ArrayList(tmp))
        }
        return res
    }
}

fun main() {
    val nums = arrayOf(1,2,3)
    Subsets().subsets(nums.toIntArray())
}