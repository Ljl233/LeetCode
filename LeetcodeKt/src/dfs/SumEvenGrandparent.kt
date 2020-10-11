package dfs
/*
1315. 祖父节点值为偶数的节点和

给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

    该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）

如果不存在祖父节点值为偶数的节点，那么返回 0 。



示例：

输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。

 */
class SumEvenGrandparent {
        var sum = 0
        fun sumEvenGrandparent(root: TreeNode?): Int {
            dfs(root)
            return sum
        }

        fun dfs(root: TreeNode?) {
            if (root == null) return
            if (root.`val` % 2 == 0) {
                dfsGrandson(root)
                root.`val` -= 1
            }
            dfs(root.left)
            dfs(root.right)
        }

        fun dfsGrandson(root: TreeNode) {
            val left = root.left
            left?.left?.let {
                sum += it.`val`
            }
            left?.right?.let {
                sum += it.`val`
            }
            val right = root.right
            right?.left?.let { sum += it.`val` }
            right?.right?.let { sum += it.`val` }
        }
}