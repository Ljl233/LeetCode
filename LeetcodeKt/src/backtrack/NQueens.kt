package backtrack

/*
#51. N 皇后
 */
class NQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val queens = IntArray(n)
        val cols = HashSet<Int>()
        val diagonals1 = HashSet<Int>()
        val diagonals2 = HashSet<Int>()
        backtrack(res, queens, 0, n, cols, diagonals1, diagonals2)
        return res
    }

    private fun generate(queens: IntArray, n: Int): List<String> {
        val ans = mutableListOf<String>()
        queens.forEach { col ->
            val chars = CharArray(n){'.'}
            chars[col] = 'Q'
            ans.add(String(chars))
        }
        return ans
    }

    private fun backtrack(
            res: MutableList<List<String>>,
            queens: IntArray,
            row: Int,
            n: Int,
            cols: HashSet<Int>,
            diagonals1: HashSet<Int>,
            diagonals2: HashSet<Int>) {
        if (row == n) {
            res.add(generate(queens, n))
            return
        }

        for (col in 0 until n) {
            if (cols.contains(col)) continue

            val diagonal1 = row + col
            if (diagonals1.contains(diagonal1)) continue

            val diagonal2 = row - col
            if (diagonals2.contains(diagonal2)) continue

            queens[row] = col
            cols.add(col)
            diagonals1.add(diagonal1)
            diagonals2.add(diagonal2)
            backtrack(res, queens, row + 1, n, cols, diagonals1, diagonals2)

            queens[row] = -1
            cols.remove(col)
            diagonals1.remove(diagonal1)
            diagonals2.remove(diagonal2)

        }

    }
}

/*


class NQueens {
    val res = mutableListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
        val board = List<CharArray>(n) {
            CharArray(n) { '.' }
        }
        backtrack(board, 0)
        return res
    }

    /**
     * 路径：board
     * 选择列表: row之后的列为可选择的
     * 结束条件: row = n
     */
    fun backtrack(board: List<CharArray>, row: Int) {
        if (row == board.size) {
            val strings = mutableListOf<String>()
            board.forEach { chars ->
                run {
                    strings.add(String(chars))
                }
            }
            res.add(strings)
            return
        }

        for (i in board[0].indices) {
            if (!isValid(board, row, i)) continue
            board[row][i] = 'Q'
            backtrack(board, row + 1)
            board[row][i] = '.'
        }
    }

    fun isValid(board: List<CharArray>, row: Int, col: Int): Boolean {

        // check if there is 'Q' in this col
        for (i in board.indices) {
            if (board[i][col] == 'Q') return false
        }

        var i = row - 1
        var j = col - 1
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false
            i--
            j--
        }

        i = row - 1
        j = col + 1
        while (i >= 0 && j < board.size) {
            if (board[i][j] == 'Q') return false
            i--
            j++
        }

        return true
    }
}

 */

fun main() {
    NQueens().solveNQueens(4)
}