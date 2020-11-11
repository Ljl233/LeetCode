package backtrack

import java.util.*

class NQueens {
    val res = mutableListOf<List<CharArray>>()
    fun solveNQueens(n: Int): List<List<String>> {
        val board = List<CharArray>(n) {
            CharArray(n) { '.' }
        }
        backtrack(board, 0)
        val ans = mutableListOf<List<String>>()
        res.forEach {
            val strings = mutableListOf<String>()
            it.forEach { chars ->
                run {
                    strings.add(String(chars))
                }
            }
            ans.add(strings)
        }
        return ans
    }

    /**
     * 路径：board
     * 选择列表: row之后的列为可选择的
     * 结束条件: row = n
     */
    fun backtrack(board: List<CharArray>, row: Int) {
        if (row == board.size) {
            res.add(board.toList())
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
            j--
        }

        return true
    }
}

fun main() {
    NQueens().solveNQueens(4)
}