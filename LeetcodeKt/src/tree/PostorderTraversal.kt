package tree

import java.util.*


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
class PostorderTraversal {
//    fun postorderTraversal(root: TreeNode?): List<Int> {
//        val list = mutableListOf<Int>()
//        postorderTraversal(root, list)
//        return list
//    }

    fun postorderTraversal(root: TreeNode?, list: MutableList<Int>) {
        if (root != null) {
            postorderTraversal(root.left, list)
            postorderTraversal(root.right, list)
            list.add(root.`val`)
        }
    }

    fun postorder(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()

        var cur = root
        while (cur != null || stack.isNotEmpty()) {
            if (cur?.left != null) {
                stack.push(cur)
                if (cur.right != null)
                    stack.push(cur.right)
                cur = cur.left
            } else {
                if (cur != null) {
                    if (cur.right != null) {
                        stack.push(cur)
                        cur = cur.right
                    } else {
                        list.add(cur.`val`)
                        cur = stack.pop()
                    }
                }
            }
        }
        return list
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val stack = LinkedList<TreeNode?>()
        val output = LinkedList<Int>()
        stack.add(root ?: return output)
        while (stack.isNotEmpty()) {
            val node = stack.poll() ?: break
            output.push(node.`val`)
            node.left?.let(stack::push)
            node.right?.let(stack::push)
        }
        return output
    }
}