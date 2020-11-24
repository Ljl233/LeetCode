package math

/*
1342. 将数字变成 0 的操作次数
 */
class NumberOfSteps {
    fun numberOfSteps(num: Int): Int {
        var ans = 0
        var temp = num
        while (temp != 0) {
            if (temp % 2 == 0) {
                temp /= 2
            } else {
                temp -= 1
            }
            ans++
        }
        return ans
    }
}