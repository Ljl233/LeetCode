package node;

public class NodeTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Boolean bool = new Palindrome().isPalindrome(head);
        System.out.println(bool);
    }
}
