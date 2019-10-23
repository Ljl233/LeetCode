package binarySearch;

import java.util.ArrayList;

public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();

        int[] little, big;
        if (len1 > len2) {
            big = nums1;
            little = nums2;
        } else {
            big = nums2;
            little = nums1;
        }
        int start = -1;

        for (int i = 0; i < little.length; i++) {
            int index = search(big, little[i], start);
            if (index >= 0) {
                start++;
                list.add(little[i]);

                int temp = big[start];
                big[start] = big[index];
                big[index] = temp;
            }
        }


        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private static int search(int[] nums, int target, int start) {
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] nums, int target, int start) {
        int left = start + 1;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return index;
    }
}
