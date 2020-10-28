package array

class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var i = 0
        for (j in 1 until nums.size) {
            if (nums[i] != nums[j]) {
                i++
                nums[i] = nums[j]
            }
        }
        return i + 1
    }
}

fun main() {
    val array = intArrayOf(
            0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    RemoveDuplicates().removeDuplicates(array).let(::println)
    array.forEach { print("$it,") }
}