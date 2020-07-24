package node;

import java.util.List;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    //后插法
    public ListNode reverseList(ListNode head) {

        ListNode p = null;
        ListNode s = null;
        p = head;
        s = p;
        int len = 0;
        if (p != null) {
            while (p.next != null) {
                p = p.next;
                len++;
            }
            for (int i = 0; i < len; i++) {
                ListNode y = s.next;
                s.next = p.next;
                p.next = s;
                s = y;
            }
        }
        return p;

    }

    //前插法
    public ListNode reverseListFront(ListNode head) {
        ListNode temp = head;
        ListNode result = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = result;
            result = temp;
            temp = next;
        }
        return result;
    }


}
