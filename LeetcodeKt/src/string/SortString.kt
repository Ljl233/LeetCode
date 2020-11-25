package string

import java.lang.StringBuilder
import kotlin.concurrent.fixedRateTimer

/*
1370. 上升下降字符串
 */
class SortString {
    fun sortString(s: String): String {
        val chars = mutableListOf<Char>()
        s.toCharArray().forEach { c: Char ->
            chars.add(c)
        }
        chars.sort()

        val sb = StringBuilder()

        while (chars.isNotEmpty()) {
            var min = chars[0]
            sb.append(chars[0])
            chars.remove(chars[0])
            var i = 0
            while (i < chars.size) {
                if (chars[i] != min) {
                    sb.append(chars[i])
                    min = chars[i]
                    chars.removeAt(i)
                } else
                    i++
            }

            if (chars.size == 0) break
            var max = chars[chars.size - 1]
            sb.append(max)
            chars.remove(max)

            if (chars.size == 0) break
            var j = chars.size - 1
            while (j >= 0) {
                if (chars[j] != max) {
                    sb.append(chars[j])
                    max = chars[j]
                    chars.removeAt(j)
                }
                j--
            }
        }
        return sb.toString()
    }
}

fun main() {
    SortString().sortString("leetcode").let(::println)
}