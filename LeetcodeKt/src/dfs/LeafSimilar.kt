package dfs

import tree.TreeNode

/*
872. 叶子相似的树
请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 */
class LeafSimilar {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        findLeaves(root1, list1)
        findLeaves(root2, list2)

        return isEquals(list1, list2)
    }

    fun findLeaves(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            list.add(root.`val`)
        } else {
            findLeaves(root.left, list)
            findLeaves(root.right, list)
        }
    }

    fun isEquals(list1: List<Int>, list2: List<Int>): Boolean {
        if (list2.size != list1.size) return false
        for (i in list1.indices) {
            if (list1[i] != list2[i]) return false
        }
        return true
    }
}