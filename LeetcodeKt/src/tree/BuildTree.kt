package tree

// 中序遍历，后序遍历
/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
class BuildTree {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val size = inorder.size
        val rootVal = postorder[size - 1]
        val root: TreeNode = TreeNode(rootVal)

        val rootIndexInorder: Int = index(inorder, rootVal)
        val rightIndexPostorder: Int = index(postorder, inorder[rootIndexInorder + 1])
        root.left = buildTree(cutArray(inorder, 0, rootIndexInorder - 1),
                cutArray(postorder, 0, rightIndexPostorder - 1))
        root.right = buildTree(cutArray(inorder, rootIndexInorder + 1, size - 1), cutArray(postorder,
                rightIndexPostorder, size - 2))
        return root
    }

    fun findRoot(postorder: IntArray, left: Int, right: Int): TreeNode? {
        return TreeNode(postorder[right])
    }

    fun index(intArray: IntArray, target: Int): Int {
        var i = 0
        val size = intArray.size
        while (i < size) {
            if (intArray[i] == target)
                return i
        }
        return -1
    }

    fun cutArray(array: IntArray, start: Int, end: Int): IntArray {
        val result: IntArray = IntArray(end - start + 1)
        var i = 0
        while (start + i <= end) {
            result[i] = array[start + i]
            i++
        }
        return result
    }
}