package bfs

import tree.TreeNode
import java.util.*
/*
993. 二叉树的堂兄弟节点
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。



示例 1：


输入：root = [1,2,3,4], x = 4, y = 3
输出：false
示例 2：


输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
示例 3：



输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false
 */
class IsCousins {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val queue = LinkedList<TreeNode>()
        if (root == null) return false
        queue.add(root)
        while (queue.isNotEmpty()) {
            val n = queue.size
            var xParent = -1
            var yParent = -1

            for (i in 0 until n) {
                val node = queue.poll()
                val parent = node.`val`
                val left = node.left
                val right = node.right

                when {
                    left == null -> null
                    left.`val` == x -> xParent = parent
                    left.`val` == y -> yParent = parent
                    else -> queue.add(left)
                }
                when {
                    right == null -> null
                    right.`val` == x -> xParent = parent
                    right.`val` == y -> yParent = parent
                    else -> queue.add(right)
                }
                if (xParent == yParent && xParent == -1) continue
                if (xParent == yParent) return false
                if (xParent != -1 && yParent != -1) return true
            }
        }
        return false
    }
}