package greed;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        if (size == 0) return 0;
        else if (size == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        int first = maxHeap.poll();
        int second = maxHeap.poll();
        while (first != 0 && second != 0) {
            maxHeap.add(Math.abs(first - second));
            first = maxHeap.poll();
            try {
                second = maxHeap.poll();
            } catch (NullPointerException e) {
                second = 0;
            }
//            if (maxHeap.size() > 1) {
//                second = maxHeap.poll();
//            } else second = 0;
        }
        return first;
    }

}
