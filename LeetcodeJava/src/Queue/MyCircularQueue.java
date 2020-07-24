package Queue;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    private int[] circularQueue;
    private int maxSize;
    private int size;
    private int head;
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.circularQueue = new int[k];
        maxSize = k;
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (size == maxSize) return false;
        tail = (tail + 1) % maxSize;
        if(size == 0){
            head = tail;
        }
        size++;
        circularQueue[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size == 0) return false;
        head = (head + 1) % maxSize;
        size--;
        return true;

    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (size == 0) return -1;

        return circularQueue[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (size == 0) return -1;

        return circularQueue[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == maxSize;
    }
}
