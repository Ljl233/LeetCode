package backtrack

import java.util.*

/*
#46 全排列
 */
class Permutations {
    val res = mutableListOf<MutableList<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        val track = mutableListOf<Int>()
        backtrack(nums, track)
        return res
    }

    fun backtrack(nums: IntArray, track: MutableList<Int>) {
        if (track.size == nums.size) {
            res.add(LinkedList(track))
            return
        }

        nums.forEach { num ->
            if (!track.contains(num)) {
                track.add(num)
                backtrack(nums, track)
                track.remove(num)
            }
        }
    }
}