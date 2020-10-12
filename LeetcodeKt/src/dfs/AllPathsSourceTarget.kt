package dfs

/*
797. 所有可能的路径
给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。



示例 1：



输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
示例 2：



输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
示例 3：

输入：graph = [[1],[]]
输出：[[0,1]]
示例 4：

输入：graph = [[1,2,3],[2],[3],[]]
输出：[[0,1,2,3],[0,2,3],[0,3]]
示例 5：

输入：graph = [[1,3],[2],[3],[]]
输出：[[0,1,2,3],[0,3]]


提示：

结点的数量会在范围 [2, 15] 内。
你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 */

class AllPathsSourceTarget {

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        return solve(graph, 0)
    }

    fun solve(graph: Array<IntArray>, node: Int): MutableList<MutableList<Int>> {
        val n = graph.size
        val ans = mutableListOf<MutableList<Int>>()
        if (node == n - 1) {
            val path = mutableListOf<Int>()
            path.add(n - 1)
            ans.add(path)
            return ans
        }

//        graph[node].forEach { nei ->
//            solve(graph, nei).forEach { path ->
//                path.add(0, node)
//                ans.add(path)
//            }
//        }
        for (nei in graph[node]) {
            for (path in solve(graph, nei)) {
                path.add(0,node)
                ans.add(path)
            }
        }

        return ans
    }

}

/*
class Solution {

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        return mutableListOf<List<Int>>().apply {
            search(0, ArrayDeque(listOf(0)), this, graph)
        }
    }

    private fun search(
        node: Int,
        path: ArrayDeque<Int>,
        result: MutableList<List<Int>>,
        graph: Array<IntArray>
    ) {
        if (node == graph.size - 1) {
            result.add(path.toList())
            return
        }

        graph[node].forEach { next ->
            path.addLast(next)
            search(next, path, result, graph)
            path.removeLast()
        }
    }
}
 */
