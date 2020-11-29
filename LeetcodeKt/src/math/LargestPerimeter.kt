package math

/*
976. 三角形的最大周长
 */
class LargestPerimeter {
    fun largestPerimeter(A: IntArray): Int {
        A.sort()
        val n = A.size
        for (i in (n - 1) downTo 2) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2]

            }
        }
        return 0
    }
}