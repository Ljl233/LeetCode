package dfs
/*
559. N叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

例如，给定一个 3叉树 :
我们应返回其最大深度，3。
 */
class NMaxDepth {
    fun maxDepth(root: Node?): Int {
        if (root == null) return 0
        var max = 0
        root.children.forEach {
            max = Math.max(max, maxDepth(it))
        }
        return max + 1
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
}

