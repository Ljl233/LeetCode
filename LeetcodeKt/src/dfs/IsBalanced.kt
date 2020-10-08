package dfs

/*
110. 平衡二叉树

给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7

返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

返回 false 。
 */
class IsBalanced {
    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) >= 0
    }

    fun height(root: TreeNode?): Int {
        if (root == null) return 0
        val leftHeight = height(root.left)
        val rightHeight = height(root.right)
        return if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            -1
        } else {
            Math.max(leftHeight, rightHeight) + 1
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}