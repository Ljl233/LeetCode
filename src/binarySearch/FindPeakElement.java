package binarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    int search(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        if (l == r) return l;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

}
