package node;

class MyLinkedList {

    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }


    }

    private Node head;
    private int val, size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        Node node = new Node(0);
        head = node;
        val = node.val;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node temp = head;
        if (index < 0 || index >= size) return -1;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (size == 0) head.val = val;
        else {
            Node h = head;
            Node temp = new Node(val);
            temp.next = h;
            head = temp;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (size == 0) head.val = val;
        else {
            Node temp = new Node(val);
            Node h = head;
            while (h.next != null) {
                h = h.next;
            }
            h.next = temp;
            size++;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (size < index) return;
        if (size <= 0) {
            addAtHead(val);
            return;
        }
        if (size == index) {
            addAtTail(val);
            return;
        }
        Node temp = new Node(val);
        Node h = head;
        if (index == 0) {
            h.next = temp;
            head = h;
            size++;
            return;
        }
        while (h.next != null && index > 1) {
            h = h.next;
            index--;
        }
        if (h.next != null) {
            temp.next = h.next;
            h.next = temp;
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            size--;
            return;

        }
        Node h = head;
        while (h.next != null && index > 1) {
            h = h.next;
            index--;
        }
        size--;
        if (h.next != null)
            h.next = h.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */