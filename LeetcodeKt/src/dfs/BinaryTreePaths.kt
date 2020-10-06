package dfs

import tree.TreeNode
import java.lang.StringBuilder

/*
257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
class BinaryTreePaths {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val list: MutableList<String> = mutableListOf()
        if (root == null) return list
        printString(root, "", list)
        return list
    }

    fun printString(root: TreeNode?, sb: String, list: MutableList<String>) {
        if (root == null) return
        var s = sb
        s += root.`val`.toString()
        if (root.left == null && root.right == null) {
            list.add(s)
        } else {
            s += "->"
            printString(root.left, s, list)
            printString(root.right, s, list)
        }
    }
}