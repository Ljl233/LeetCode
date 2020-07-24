package athority;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */


import org.junit.jupiter.api.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p, h, next;
        h = head;
        p = head.next;
        while (p != null) {
            next = p.next;
            p.next = h;
            h = p;
            p = next;
        }
        return h;
    }

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        reverseList(head);
    }
}


@SuppressWarnings("all")
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}