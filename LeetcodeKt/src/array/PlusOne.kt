package array
/*
#66. 加一
https://leetcode-cn.com/problems/plus-one/
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        var i = digits.size - 1
        while (i >= 0) {
            digits[i]++
            if (digits[i] == 10) {
                digits[i] = 0
                i--
            } else {
                i = -2
            }
        }
        if (i == -1) {
            val res = IntArray(digits.size + 1)
            res[0] = 1
            var j = 1
            while (j < res.size) {
                res[j] = digits[j - 1]
                j++
            }
            return res
        }
        return digits
    }
}
/*
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) {
        return intArrayOf()
    }
    val resList = arrayListOf<Int>()
    var flag = 0
    var tmp: Int
    val arrSize = digits.size - 1
    for (i in arrSize downTo 0) {
        tmp = digits[i]
        if (i == arrSize) {
            if (tmp + 1 == 10) {
                resList.add(0,0)
                flag = 1
            } else {
                resList.add(0,tmp + 1)
            }
        } else {
            if (tmp + flag == 10) {
                resList.add(0,0)
                flag = 1
            } else {
                resList.add(0,tmp + flag)
                flag = 0
            }
        }
    }
    if (flag == 1) {
        resList.add(0,1)
    }
    return resList.toIntArray()
    }
}
 */