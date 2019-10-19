package binarySearch;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start < end) {
            if (target == nums[(start + end) / 2]) {
                return (start + end) / 2;
            }
            if (target < nums[(start + end) / 2]) {
                end = (start + end) / 2;
            } else {
                start = (start + end) / 2 + 1;
            }
        }
        if (target > nums[start]) {
            return start + 1;
        } else
            return start;
    }


}
