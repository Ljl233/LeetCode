package binarySearch;

public class SearchVorticalArray {
    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;

        int rotate = findRotateIndex(0, n - 1);
        // if target is the smallest element
        if (nums[rotate] == target)
            return rotate;
        // if array is not rotated, search in the entire array
        if (rotate == 0)
            return search(0, n - 1);

        if (target < nums[0]) {
            return search(rotate, n - 1);
        }
        return search(0, rotate);

    }

    private int findRotateIndex(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                if (nums[mid] < nums[left]) {
                    right = mid - 1;
                } else  {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }


    private int search(int left, int right) {


        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}