package node;

public class LinkListTest {
    public static void main(String[] args) {
        int a_1, a_2, a_3;
        MyLinkedList obj = new MyLinkedList();
        //  int param_1 = obj.get(index);
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        a_1 = obj.get(1);
        obj.deleteAtIndex(0);
        a_2 = obj.get(0);
        // obj.addAtTail(val);
        //obj.deleteAtIndex(index);
         a_3 = obj.get(0);
        System.out.println("a1:" + a_1 + "   a2:" + a_2 + "    a3:" + a_3);
    }
}
