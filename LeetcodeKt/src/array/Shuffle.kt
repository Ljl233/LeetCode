package array
/*
#1470 重新排列数组
 */
class Shuffle {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val res = IntArray(2 * n)
        for (i in 0 until n) {
            res[i * 2] = nums[i]
            res[i * 2 + 1] = nums[i + n]
        }
        return res
    }
}