package bfs

import tree.TreeNode
/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
class LevelOrder {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        levelOrder(root, ans, 0)
        return ans
    }

    fun levelOrder(root: TreeNode?, ans: MutableList<MutableList<Int>>, level: Int) {
        if (root == null) return

        var list = ans.getOrNull(level)
        if (list == null) {
            list = mutableListOf<Int>()
            ans.add(level, list)
        }
        list.add(root.`val`)

        levelOrder(root.left, ans, level + 1)
        levelOrder(root.right, ans, level + 1)
    }
}