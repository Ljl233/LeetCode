package tree

import kotlin.math.max
/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
class MaxDepth {
    var ans: Int = 0;
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.right == null && root.left == null) return 1
        maxDepth(root, 1)
        return ans
    }

    fun maxDepth(root: TreeNode?, depth: Int) {
        //from top to bottom
        if (root == null) return

        if (root.left == null && root.right == null) ans = Math.max(ans, depth)

        maxDepth(root.left, depth + 1)
        maxDepth(root.right, depth + 1)
    }
}