package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        int left = 0, right = nums.length - 1;
//
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == mid && nums[mid - 1] == mid) {
//                return mid;
//            } else if (nums[mid] == mid && nums[mid - 1] == mid-1) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//
//        }
//        return -1;

//        int[] all = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i];
//            if (all[temp] != 0) {
//                return temp;
//            } else {
//                all[temp]++;
//            }
//        }
//        return -1;
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;

//        作者：LeetCode
//        链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
