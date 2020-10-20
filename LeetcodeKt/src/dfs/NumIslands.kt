package dfs

import java.util.*

/*
# 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
岛屿问题
解法：dfs / bfs / 并查集
对每一块区域进行遍历，如果是陆地就进行bfs，dfs，遍历出整个岛屿，res++，被遍历的陆地值改为0，防止再次遍历
bfs/dfs 的次数就是岛屿的数量。

 */
class NumIslands {
    /*  dfs
    fun numIslands(grid: Array<CharArray>): Int {
        var res = 0

        grid.forEachIndexed { i, array ->
            array.forEachIndexed { j, char ->
                if (grid[i][j] == '1') {
                    res++
                    dfs(grid, i, j)
                }
            }
        }
        return res
    }

    private fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        val nr = grid.size
        val nc = grid[0].size

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') return

        grid[i][j] = '0'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j + 1)
        dfs(grid, i, j - 1)
    }
    */

    fun numIslands(grid: Array<CharArray>): Int {
        var res = 0
        val R = grid.size
        val C = grid[0].size

        grid.forEachIndexed { i, array ->
            array.forEachIndexed { j, char ->
                if (char == '1') {
                    res++
                    grid[i][j] = '0'
                    val queue = LinkedList<Int>()
                    queue.add(i * C + j)
                    while (queue.isNotEmpty()) {
                        val id = queue.remove()
                        val row = id / C
                        val col = id % C
                        if (row + 1 <= R && grid[row + 1][col] == '1') {
                            queue.add((row + 1) * C + col)
                            grid[row + 1][col] = '0'
                        }
                        if (row - 1 > 0 && grid[row - 1][col] == '1') {
                            queue.add((row - 1) * C + col)
                            grid[row - 1][col] = '0'
                        }
                        if (col + 1 < C && grid[row][col + 1] == '1') {
                            queue.add(row * C + col + 1)
                            grid[row][col + 1] = '0'
                        }
                        if (col - 1 > 0 && grid[row][col - 1] == '1') {
                            queue.add(row * C + col - 1)
                            grid[row][col - 1] = '0'
                        }
                    }
                }
            }
        }
        return res
    }

}