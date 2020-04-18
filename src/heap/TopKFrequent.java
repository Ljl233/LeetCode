package heap;

import org.junit.jupiter.api.Test;

import java.util.*;
/*
347. 前 K 个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequency = new HashMap<>();

        //HashMap的value不能直接修改，需要使用put来覆盖
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
//        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>
//                ((o1, o2) -> o1 - o2);
//        for (int num : nums) {
//            priorityQueue2.add(num);
//        }
//        while (!priorityQueue2.isEmpty()) {
//            System.out.println(priorityQueue2.poll());
//        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>
                ((o1, o2) -> frequency.get(o1) - frequency.get(o2));

        for (int key : frequency.keySet()) {
            priorityQueue.add(key);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
        }
        Collections.reverse(res);
        return res;

    }

    @Test
    void test() {
        topKFrequent(new int[]{1, 4, 2, 3, 6, 5}, 6);
    }
}
