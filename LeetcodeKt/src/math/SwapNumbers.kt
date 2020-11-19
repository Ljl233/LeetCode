package math

/*
面试题 16.01. 交换数字
 */
class SwapNumbers {
    fun swapNumbers(numbers: IntArray): IntArray {
        numbers[0] = numbers[0] xor numbers[1]
        numbers[1] = numbers[1] xor numbers[0]
        numbers[0] = numbers[0] xor numbers[1]
        return numbers
    }
}