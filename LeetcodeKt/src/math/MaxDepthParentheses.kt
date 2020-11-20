package math

/*
1614. 括号的最大嵌套深度
 */

class MaxDepthParentheses {
    fun maxDepth(s: String): Int {
        var left = 0
        var max = 0
        if (s.length <= 1) return 0
        s.toCharArray().forEach { char ->
            if (char == '(') {
                left++
            }
            if (char == ')') {
                left--
            }
            max = Math.max(left, max)
        }
        return max
    }
}