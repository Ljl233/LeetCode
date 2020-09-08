package tree.bst

import tree.TreeNode

/*
1382. 将二叉搜索树变平衡
给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。

如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。

如果有多种构造方法，请你返回任意一种。


示例：

输入：root = [1,null,2,null,3,null,4,null,null]
输出：[2,1,3,null,null,null,4]
解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。


提示：

树节点的数目在 1 到 10^4 之间。
树节点的值互不相同，且在 1 到 10^5 之间。
 */
class BalanceBST {
    val list = mutableListOf<Int>()
    fun balanceBST(root: TreeNode?): TreeNode? {
        if (root == null) return root
        getInorder(root)

        return reBuild(0, list.size - 1)
    }

    private fun reBuild(l: Int, r: Int): TreeNode? {
        val mid = (l + r) / 2
        val node: TreeNode = TreeNode(list[mid])

        if (l <= mid - 1) node.left = reBuild(l, mid - 1)
        if (r >= mid + 1) node.right = reBuild(mid + 1, r)

        return node
    }

    private fun getInorder(root: TreeNode?) {
        if (root != null) {
            getInorder(root.left)
            list.add(root.`val`)
            getInorder(root.right)
        }
    }
}

fun main() {
    val node = TreeNode(1)
    node.right = TreeNode(2)
    node.right?.right = TreeNode(3)
    node.right?.right?.right = TreeNode(4)

    BalanceBST().balanceBST(node)
}