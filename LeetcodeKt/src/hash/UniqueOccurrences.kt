package hash
/*
    1207. 独一无二的出现次数
    https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
class UniqueOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
/*        val hashMap = HashMap<Int, Int>()

        arr.forEach { num ->
            val value = hashMap.get(num) ?: 0
            hashMap.set(num, value + 1)
        }
        val values = hashMap.values.sorted()
        for (i in 0 until values.size - 1) {
            if (values[i] == values[i + 1]) return false
        }
        return true*/

        val array = IntArray(2001) { 0 }
        val array1 = IntArray(1001) { 0 }
        arr.forEach { num ->
            array[num + 1000]++
        }
        for (i in array.indices)    {
            val it = array[i]
            if (it == 0) continue
            if (array1[it] != 0) return false
            array1[it]++
        }
        return true
    }
}