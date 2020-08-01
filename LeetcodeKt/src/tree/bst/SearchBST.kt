package tree.bst

import tree.TreeNode

class SearchBST {
    fun searchBST(root: TreeNode?, target: Int): Boolean {
        if (root == null) return false
        if (target == root.`val`) return true
        if (target > root.`val`) return searchBST(root.right, target)
        else return searchBST(root.left, target)
    }
}