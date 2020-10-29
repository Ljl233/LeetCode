package dfs

/*
# 129. 求根到叶子节点数字之和
https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
class SumNumbers {

/*
    var res = 0
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root, root.`val`)
        return res
    }

    fun dfs(root: TreeNode?, sun: Int) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            res += sun
        } else {
            root.left?.let { left ->
                dfs(root.left, sun * 10 + left.`val`)
            }
            root.right?.let { right ->
                dfs(root.right, sun * 10 + right.`val`)
            }
        }
    }

 */

    var res = 0
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root, 0)
        return res
    }

    fun dfs(root: TreeNode?, sum: Int) {
        if (root == null) return
        if (root.left == null && root.right == null) {
            res += sum * 10 + root.`val`
        } else {
            dfs(root.left, sum * 10 + root.`val`)
            dfs(root.right, sum * 10 + root.`val`)
        }
    }

    fun helper(root: TreeNode?, sum: Int): Int {
        if (root == null) return 0
        val tmp = sum * 10 + root.`val`
        return if (root.right == null && root.left == null) tmp
        else helper(root.left, tmp) + helper(root.right, tmp)
    }
}