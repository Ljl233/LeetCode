package tree

import java.util.*
import kotlin.collections.ArrayList

/**
 * 前序遍历,递归
 */
class PreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
//        preorderTraversal(root, list)
        return preorderIterate(root)
//        return list
    }

    fun preorderTraversal(root: TreeNode?, list: ArrayList<Int>) {
        if (root != null) {
            list.add(root.value)
            if (root.left != null)
                preorderTraversal(root.left, list)
            if (root.right != null)
                preorderTraversal(root.right, list)
        }
        return
    }

    fun preorderIterate(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        val stack = Stack<TreeNode>()
        if (root != null) {
            list.add(root.value)
            if (root.right != null) stack.push(root.right)

            if (root.left != null) stack.push(root.left)

            while (!stack.empty()) {
                val root = stack.pop()
                list.add(root.value)
                if (root.right != null) stack.push(root.right)
                if (root.left != null) stack.push(root.left)
            }
        }
        return list
    }

}

fun main() {
    var ti = TreeNode(5)
    var v = ti.value
}

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */