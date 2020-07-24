package tree

import java.util.*

class LevelOrder {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var queue = LinkedList<TreeNode>()
        val ans = mutableListOf<List<Int>>()
        if (root == null) return ans;
        queue.add(root)

        val list = mutableListOf(root.`val`)
        ans.add(list)
        while (queue.isNotEmpty()) {
            val element = mutableListOf<Int>()
            val q = LinkedList<TreeNode>()

            while (queue.isNotEmpty()) {
                val node = queue.pop()
                val left = node.left
                if (left != null) {
                    element.add(left.`val`)
                    q.add(left)
                }

                val right = node.right
                if (right != null) {
                    element.add(right.`val`)
                    q.add(right)
                }
            }
            if (element.isNotEmpty())
                ans.add(element)
            queue = q
        }
        return ans
    }
}

fun main() {
    val v = mutableListOf(3, 9, 20, null, null, 15, 7)
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)

    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)

    LevelOrder().levelOrder(root).let(::println)
}