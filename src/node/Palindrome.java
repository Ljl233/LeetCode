package node;

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
    //        System.out.println("head == null || head.next == null");
            return true;
        }
        ListNode slow = head;
        ListNode quick = slow;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
//        System.out.println("head.val--->"+head.val);
//        System.out.println("slow.val--->"+slow.val);
//        System.out.println("fast.val--->"+quick.val);
 //       System.out.println("reverse(slow.next).val--->"+reverse(slow.next).val);
//        System.out.println("reverse(slow.next).next.val--->"+reverse(slow.next).next.val);
        return compare(head, reverse(slow.next));

    }


    private boolean compare(ListNode first, ListNode second) {
        while (first != null && second != null) {
            System.out.println("mmmmmmmmm");
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;

    }

    ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode next = null;
        ListNode pre = null;
        while (temp != null) {
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
//        System.out.println("pre.val--->"+pre.val);
//        System.out.println("pre.next.val--->"+pre.next.val);

        return pre;
    }
}