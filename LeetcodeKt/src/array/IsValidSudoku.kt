package array
/*
#36. 有效的数独
https://leetcode-cn.com/problems/valid-sudoku/
 */
class IsValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array<HashMap<Int, Int>>(9) { HashMap() }
        val cols = Array<HashMap<Int, Int>>(9) { HashMap() }
        val boxes = Array<HashMap<Int, Int>>(9) { HashMap() }

        for (i in 0..8) {
            for (j in 0..8) {
                val char = board[i][j]
                if (char != '.') {
                    val num = char.toInt()
                    val box_index = (i / 3) * 3 + j / 3
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1)
                    cols[j].put(num, cols[j].getOrDefault(num, 0) + 1)
                    boxes[box_index].put(num, boxes[box_index].getOrDefault(num, 0) + 1)

                    if (rows[i].get(num)!! > 1 || cols[j].get(num)!! > 1 || boxes[box_index].get(num)!! > 1) {
                        return false
                    }
                }
            }
        }
        return true
    }
}