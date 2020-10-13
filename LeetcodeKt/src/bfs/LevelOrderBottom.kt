package bfs

import dfs.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/*
107. 二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 */
class LevelOrderBottom {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val res = LinkedList<ArrayList<Int>>()
        val queue = LinkedList<TreeNode>()

        if (root == null) return res
        queue.offer(root)


        while (queue.isNotEmpty()) {
            val n = queue.size
            val list = ArrayList<Int>()
            for (i in 0 until n) {
                val node = queue.poll()
                list.add(node.`val`)
                node.left?.let(queue::offer)
                node.right?.let(queue::offer)
            }
            res.addFirst(list)
        }

        return res
    }
}