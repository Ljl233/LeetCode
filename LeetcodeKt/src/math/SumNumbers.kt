package math

/*
剑指 Offer 64. 求1+2+…+n
 */
class SumNumbers {
    fun sumNums(n: Int): Int {
        var result = n
        val b = n > 0 && (result.apply {
            result += sumNums(n - 1)
        }) > 0
        return result
    }
}