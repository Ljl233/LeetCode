package node;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        l1.traverse(l1);
//        l2.traverse(l2);
        ListNode res = new ListNode(0);
        ListNode head = res;
        int sign = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);

            int he = l1.val + l2.val + sign;
            if (he >= 10) {
                he = he - 10;
                sign = 1;
            } else sign = 0;

            head.val += he;

            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null) {
                head.next = new ListNode(0);
                head = head.next;

            }
        }


        if (sign == 1) {
            head.next = new ListNode(1);
        } else {
            head = null;
            //   System.out.println("head = null;");
        }
        //     res.traverse(res);
        return res;
    }
}
