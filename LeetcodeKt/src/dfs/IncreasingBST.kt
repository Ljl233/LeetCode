package dfs

import tree.TreeNode

/*
897. 递增顺序查找树
给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。



示例 ：

输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9
 */


class IncreasingBST {

    var res: TreeNode? = null
    var node: TreeNode? = null

    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root == null) return null
        dfs(root)
        return res
    }

    fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.left)
        if (root.left == null && res == null) {
            res = TreeNode(root.`val`)
            node = res
        } else {
            node?.right = TreeNode(root.`val`)
            node = node?.right
        }
        dfs(root.right)
    }

}