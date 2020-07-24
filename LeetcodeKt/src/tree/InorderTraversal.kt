package tree

import java.util.ArrayDeque

class InorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        traversal(root, list)
        return list
    }

    fun traversal(root: TreeNode?, list: ArrayList<Int>) {
        if (root != null) {
            traversal(root.left, list)
            list.add(root.`val`)
            traversal(root.right, list)
        }
    }

    //迭代
    fun inorder(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()

        var curr = root
        while (curr != null || stack.isNotEmpty()) {
            // 判断左孩子是否为空，不为空，入栈当前节点，并把左孩子设为当前节点
            if (curr?.left != null) {
                stack.push(curr)
                curr = curr.left
            } else {
                // 当前值添加到列表
                if (curr != null) {
                    list.add(curr.`val`)

                    // 右子节点设为当前节点
                    curr = curr.right
                    while (curr == null && stack.isNotEmpty()) {
                        val node = stack.pop()
                        list.add(node.`val`)
                        curr = node.right
                    }
                }
            }
        }
        return list
    }
}


//fun inorderAgain(root: TreeNode?): List<Int> {
//    val list = mutableListOf<Int>()
//    val stack = ArrayDeque<TreeNode>()
//
//    var cur = root
//    while (cur != null || stack.isNotEmpty()) {
//        if (cur?.left != null) {
//            stack.push(cur)
//            cur = cur.left
//        } else {
//            if (cur != null) {
//                list.add(cur.value)
//
//                cur = cur.right
//                while (cur == null && stack.isNotEmpty()) {
//                    val node = stack.pop()
//                    list.add(node.value)
//                    cur = node.right
//                }
//            }
//
//        }
//    }
//
//    return list
//}