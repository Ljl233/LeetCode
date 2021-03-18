package linkedlist

/*
160. 相交链表
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var nodeA = headA
        var nodeB = headB
        while (nodeA != null) {
            while (nodeB != null) {
                if (nodeA == nodeB) {
                    return nodeA
                }
                nodeB = nodeB.next
            }
            nodeB = headB
            nodeA = nodeA.next
        }
        return nodeA
    }
}


//<editor-fold desc="hashset">
fun getIntersectionNodeHashSet(headA: ListNode?, headB: ListNode?): ListNode? {
    val hashSet = HashSet<ListNode>()
    var nodeA = headA
    while (nodeA != null) {
        hashSet.add(nodeA)
        nodeA = nodeA.next
    }

    var nodeB = headB
    while (nodeB != null) {
        if (hashSet.contains(nodeB)) {
            return nodeB
        }
        nodeB = nodeB.next
    }
    return null
}
//</editor-fold>

//<editor-fold desc="romantic function">
fun getIntersectionNodeTwoPoints(headA: ListNode?, headB: ListNode?): ListNode? {
    var nodeA = headA
    var nodeB = headB

    var endA: ListNode? = null
    var endB: ListNode? = null

    while (nodeA != nodeB) {

        if (endA != null && endB != null && endA != endB) {
            return null
        }

        if (nodeA?.next != null) {
            nodeA = nodeA.next
        } else {
            endA = nodeA
            nodeA = headB
        }
        if (nodeB?.next != null) {
            nodeB = nodeB.next
        } else {
            endB = nodeB
            nodeB = headA
        }
    }
    return nodeA
}
//</editor-fold>

