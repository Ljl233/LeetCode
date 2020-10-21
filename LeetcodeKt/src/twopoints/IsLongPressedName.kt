package twopoints

/*
925. 长按键入 https://leetcode-cn.com/problems/long-pressed-name/

双指针

 */
class IsLongPressedName {
    fun isLongPressedName(name: String, typed: String): Boolean {
        var i = 0
        var j = 0
        while (j < typed.length) {
            if (i < name.length && name[i] == typed[j]) {
                i++
                j++
            } else if (j > 0 && typed[j] == typed[j - 1]) {
                j++
            } else {
                return false
            }
        }
        return i == name.length
    }
}