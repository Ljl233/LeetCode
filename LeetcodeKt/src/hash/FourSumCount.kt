package hash

/*
454. 四数相加 II
 */
class FourSumCount {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val hashMap = HashMap<Int, Int>()
        A.forEach { a ->
            B.forEach { b ->
                hashMap[a + b] = hashMap.getOrDefault(a + b, 0) + 1
            }
        }
        var ans = 0
        C.forEach { c ->
            D.forEach { d ->
                if (hashMap.containsKey(-c - d)) {
                    ans += hashMap.get(-c - d)!!
                }
            }
        }
        return ans
    }
}