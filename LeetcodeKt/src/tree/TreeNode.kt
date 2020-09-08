package tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun treeNode(array: Array<Int>): TreeNode {
    val size = array.size
    val root = TreeNode(array[0])
    root.right = treeNode(array, 2, size)
    root.left = treeNode(array, 1, size)
    return root
}

fun treeNode(array: Array<Int>, index: Int, size: Int): TreeNode? {
    if (index >= size) return null
    val node: TreeNode = TreeNode(array[index])
    node.left = treeNode(array, index * 2 + 1, size)
    node.right = treeNode(array, index * 2 + 2, size)
    return node
}

fun main() {
//    val array = arrayOf(1, 2)
//    val root = treeNode(array)

    val root = TreeNode(3 )
    root.left= TreeNode(9)
    root.right = TreeNode(20)
    root.right?.right = TreeNode(15)
    root.right?.left = TreeNode(7)

    println(MaxDepth().maxDepth(root))
}