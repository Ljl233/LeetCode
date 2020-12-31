package binarysearch

/*
374. 猜数字大小
 */

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */
class GuessNumber {
    fun guessNumber(n: Int): Int {
        var l = 0
        var r = n

        while (l <= r) {
            val mid = l + (r - l) / 2

            when (guess(mid)) {
                0 -> return mid
                1 -> l = mid + 1
                -1 -> r = mid - 1
            }
        }
        return -1
    }

    fun guess(num: Int): Int {
        return -1
    }
}