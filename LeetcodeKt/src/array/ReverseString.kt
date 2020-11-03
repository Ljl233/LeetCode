package array

/*
#344. 反转字符串
https://leetcode-cn.com/problems/reverse-string/
 */
class ReverseString {
    fun reverseString(s: CharArray): Unit {
//        val size = s.size
//        for (i in 0..(size / 2)) {
//            val temp = s[i]
//            s[i] = s[size - i - 1]
//            s[size - i - 1] = temp
//        }
        if (s.isEmpty()) return
        var left = 0
        var right = s.size - 1
        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }
}