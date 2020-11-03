package string

/*
#7. 整数反转
 */
class ReverseInteger {
    fun reverse(x: Int): Int {
        val chars = x.toString().toCharArray()
        var left = 0
        var right = chars.size - 1

        if (chars[0] == '-') {
            left = 1
        }

        while (left < right) {
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp
            left++
            right--
        }

        if (chars[0] == '-') {
            val string = String(chars, 1, chars.size - 1).toLong()
            if (string > Int.MAX_VALUE) return 0
            return string.toInt() * -1
        }
        val string = String(chars).toLong()
        if (string > Int.MAX_VALUE) return 0
        return string.toInt()
    }
}

fun main() {
    ReverseInteger().reverse(-2147483648).let(::println)
}