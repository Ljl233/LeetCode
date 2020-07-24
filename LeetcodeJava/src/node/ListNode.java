package node;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }


    void traverse(ListNode head) {
        if (head == null) System.out.println("LinkNode is null!");

        while (head != null) {
            System.out.print(head.val + "      ");
            head = head.next;
        }
        System.out.println();
    }

    ListNode addP(int[] a) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        res.val = a[0];
        for (int i = 1; i < a.length; i++) {
            ListNode next = new ListNode(a[i]);
            res.next=next;
            res=next;
        }
        traverse(head);
        return head;
    }
}