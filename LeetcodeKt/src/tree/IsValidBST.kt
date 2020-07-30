package tree
/*
面试题 04.05. 合法二叉搜索树
实现一个函数，检查一棵二叉树是否为二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 */
class IsValidBST {
    fun isValidBST(root: TreeNode?): Boolean {
        val list = mutableListOf<Int>()
        inorder(root, list)

        var i = 0;
        while (i < list.size - 1) {
            if (list[i] > list[i + 1]) return false
            i++
        }
        return true
    }

    fun inorder(root: TreeNode?, list: MutableList<Int>) {
        if (root != null) {
            inorder(root.left, list)
            list.add(root.`val`)
            inorder(root.right, list)
        }
    }

    var pre = Long.MIN_VALUE
    fun isValidBSTInOrder(root: TreeNode?): Boolean {
        if (root == null) return true
        val left = root.left
        if (left != null && !isValidBSTInOrder(left)) return false
        if (root.`val` <= pre) return false
        pre = root.`val`.toLong()
        return isValidBSTInOrder(root.right)
    }
}