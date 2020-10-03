package dfs
/*
430. 扁平化多级双向链表
多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。



示例 1：

输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
输出：[1,2,3,7,8,11,12,9,10,4,5,6]
解释：

输入的多级列表如下图所示：



扁平化后的链表如下图：


示例 2：

输入：head = [1,2,null,3]
输出：[1,3,2]
解释：

输入的多级列表如下图所示：

  1---2---NULL
  |
  3---NULL
示例 3：

输入：head = []
输出：[]
 */
class Flatten {
    fun flatten(root: Node?): Node? {
        var cur = root
        while (cur != null) {
            if (cur.child != null) {
                dfs(cur)
            }
            cur = cur.next
        }
        return root
    }

    fun dfs(cur: Node) {
        var child: Node? = cur.child ?: return
        val next = cur.next

        connect(cur, child)

        while (child?.next != null) {
            if (child.child == null) child = child.next
            else dfs(child)
        }
        if (child?.next == null) {
            connect(child, next)
        }
    }

}

fun connect(first: Node?, second: Node?) {
    first?.next = second
    second?.prev = first
}
//
//fun main() {
////    val root = Node(1)
////    root.next = Node(2)
////    root.next?.next = Node(3)
////    root.next?.next?.next = Node(4)
////    root.next?.next?.next?.next = Node(5)
////    root.next?.next?.next?.next?.next = Node(6)
////    root.next?.next?.child = Node(7)
//
//    val s = arrayOf(1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12)
//    val root = buildTree(s)
//    Flatten().flatten(root)
//}
//
//fun buildTree(array: Array<Int?>): Node? {
//    var i = 1
//    var node = Node(1)
//    val root = Node(array[0]!!)
//    var pre: Node? = null
//    while (i < array.size) {
//        if (array[i] != null) {
//            val cur = Node(array[i]!!)
//            connect(pre, cur)
//            pre = cur
//        }
//
//
//        i++
//    }
//}

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}