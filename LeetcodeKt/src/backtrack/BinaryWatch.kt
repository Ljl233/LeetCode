package backtrack

/*
401. 二进制手表
 */
class BinaryWatch {
    val ans = mutableListOf<String>()
    fun readBinaryWatch(num: Int): List<String> {
        val time = IntArray(10) { 0 }
        backtrack(time, 0, num)
        return ans
    }

    private fun backtrack(time: IntArray, now: Int, res: Int) {
        if (now == 10) return
        if (res == 0) {
//            if (isErrorExample(time)) {
//                print(1)
//            }
            ans.add(generate(time))
            return
        }


        for (i in now until 10) {
            time[i] = 1
            if (isTime(time)) {
                backtrack(time, i + 1, res - 1)
            }
            time[i] = 0
        }
    }

    private fun isTime(time: IntArray): Boolean {
        var hour = 0
        var minute = 0

        for (i in 0..3) {
            hour = hour * 2 + time[i]
        }
        if (hour > 11) return false

        for (j in 4..9) {
            minute = minute * 2 + time[j]
        }
        if (minute > 59) return false

        return true
    }

    private fun generate(time: IntArray): String {
        var hour = 0
        var minute = 0

        for (i in 0..3) {
            hour = hour * 2 + time[i]
        }
        val stringHour = hour.toString()

        for (j in 4..9) {
            minute = minute * 2 + time[j]
        }
        val stringMinute = if (minute < 10) {
            "0${minute}"
        } else {
            minute.toString()
        }

        return "${stringHour}:${stringMinute}"
    }

    fun isErrorExample(time: IntArray): Boolean {
        for (i in 0 until 9) {
            if (time[i] == 1) return false
        }
        if (time[9] == 0) return false
        return true
    }

}

fun main() {
    BinaryWatch().readBinaryWatch(2)
}