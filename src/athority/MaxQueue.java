package athority;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
    面试题59 - II. 队列的最大值
    请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

    若队列为空，pop_front 和 max_value 需要返回 -1

    示例 1：

    输入:
    ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
    [[],[1],[2],[],[],[]]
    输出: [null,null,null,2,1,2]
    示例 2：

    输入:
    ["MaxQueue","pop_front","max_value"]
    [[],[],[]]
    输出: [null,-1,-1]


    限制：

    1 <= push_back,pop_front,max_value的总操作数 <= 10000
    1 <= value <= 10^5
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> d;

    public MaxQueue() {
        queue = new LinkedList<>();
        d = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return d.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!d.isEmpty() && d.peekLast() < value) {
            d.removeLast();
        }
        d.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int poll = queue.poll();
        if (!d.isEmpty() && poll == d.peekFirst()) {
            d.removeFirst();
        }
        return poll;
    }

//    int size;
//    int max;
//    Queue<Integer> queue;
//
//    public MaxQueue() {
//        size = 0;
//        queue = new LinkedList<>();
//    }
//
//    public int max_value() {
//        if (size == 0) return -1;
//        return max;
//    }
//
//    public void push_back(int value) {
//        queue.add(value);
//        max = Math.max(max, value);
//        ++size;
//    }
//
//    public int pop_front() {
//        if (size != 0)
//            return queue.poll();// when i pop the top, the max don't change to the second top one, so i need to use a queue
//        else return -1;
//    }

    @Test
    void test() {

//        String[] methods = {"MaxQueue", "max_value", "pop_front", "max_value", "push_back", "max_value",
//                "pop_front", "max_value", "pop_front", "push_back", "pop_front", "pop_front", "pop_front", "push_back",
//                "pop_front", "max_value", "pop_front", "max_value", "push_back", "push_back", "max_value", "push_back",
//                "max_value", "max_value", "max_value", "push_back", "pop_front", "max_value", "push_back", "max_value",
//                "max_value", "max_value", "pop_front", "push_back", "push_back", "push_back", "push_back", "pop_front",
//                "pop_front", "max_value", "pop_front", "pop_front", "max_value", "push_back", "push_back", "pop_front",
//                "push_back", "push_back", "push_back", "push_back", "pop_front", "max_value", "push_back", "max_value",
//                "max_value", "pop_front", "max_value", "max_value", "max_value", "push_back", "pop_front", "push_back",
//                "pop_front", "max_value", "max_value", "max_value", "push_back", "pop_front", "push_back", "push_back",
//                "push_back", "pop_front", "max_value", "pop_front", "max_value", "max_value", "max_value", "pop_front",
//                "push_back", "pop_front", "push_back", "push_back", "pop_front", "push_back", "pop_front", "push_back",
//                "pop_front", "pop_front", "push_back", "pop_front", "pop_front", "pop_front", "push_back", "push_back",
//                "max_value", "push_back", "pop_front", "push_back", "push_back", "pop_front"};
        String[] methods = {"MaxQueue", "push_back", "push_back", "max_value", "pop_front", "max_value"};

//        String parm = "[],[],[],[],[46],[],[],[],[],[868],[],[],[],[525],[],[],[],[],[123],[646],[],[229],[],[],[],[ 871],[],[],[285],[],[],[],[],[45],[140],[837],[545],[],[],[],[],[],[],[561],[237],[],[633],[98],[806],[717],[],[],[ 186],[],[],[],[],[],[],[268],[],[29],[],[],[],[],[866],[],[239],[3],[850],[],[],[],[],[],[],[],[310],[],[674],[770],[],[525],[],[425],[],[],[720],[],[],[],[373],[411],[],[831],[],[765],[701],[]";
        String parm = "[],[1],[2],[],[],[]";
        String[] split = parm.split(",");

        int i = 0, j = 0;
        MaxQueue queue = new MaxQueue();
        int m, f;
        while (i < methods.length) {
            switch (methods[i]) {
                case "MaxQueue":
                    queue = new MaxQueue();
                    break;
                case "max_value":
                    m = queue.max_value();
                    break;
                case "pop_front":
                    f = queue.pop_front();
                    break;
                case "push_back":
                    String v = split[j].substring(1, split[j].length() - 1);
                    queue.push_back(Integer.parseInt(v));
                    break;
            }
            i++;
            j++;
        }

        MaxQueue obj = new MaxQueue();
        int value = 1;
        int param_1 = obj.max_value();
        obj.push_back(value);
        int param_3 = obj.pop_front();
    }

    @Test
    void test2() {
        Deque<Integer> deque = new ArrayDeque<>();
        d.add(1);
//        d.poll();
        System.out.println(d.toString());
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
