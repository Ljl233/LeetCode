package dfs

/*
1302. 层数最深叶子节点的和

给你一棵二叉树，请你返回层数最深的叶子节点的和。

示例：

输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15

 */
class DeepestLeavesSum {
    val map = HashMap<Int, Int>()
    fun deepestLeavesSum(root: TreeNode?): Int {
        dfs(root, 0)

        var max = Int.MIN_VALUE
        map.keys.forEach {
            max = Math.max(max, it)
        }

        if (map.get(max) == null) return 0
        return map.get(max)!!
    }

    fun dfs(root: TreeNode?, depth: Int) {
        if (root == null) return

        if (root.right == null && root.left == null) {
                map[depth] = map.getOrDefault(depth, 0) + root.`val`
        } else {
            dfs(root.left, depth + 1)
            dfs(root.right, depth + 1)
        }
    }
}