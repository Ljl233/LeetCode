package node;

public class NodeTest {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        Boolean bool = new Palindrome().isPalindrome(head);
//        System.out.println(bool);
        int[] a1=new int[]{2,4,3};
        int[] a2=new int[]{5,6,4};
        ListNode l1 = new ListNode(0);
        l1=l1.addP(a1);
        ListNode l2 = new ListNode(0);
        l2=l2.addP(a2);
        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }
}
