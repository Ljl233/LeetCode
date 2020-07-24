package arraylist;

/*
    34. 在排序数组中查找元素的第一个和最后一个位置
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。

    如果数组中不存在目标值，返回 [-1, -1]。

    示例 1:

    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]
    示例 2:

    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {

        int size = nums.length;
        int[] ans = new int[]{-1, -1};

        if (size <= 0) return ans;
        if (target < nums[0] || target > nums[size - 1]) return ans;

        int left = 0;
        int right = size;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == left && nums[mid] != target) break;
            if (nums[mid] == target) {
                ans[0] = mid;
                ans[1] = mid;
                int i = 0;
                while (mid - i - 1 >= 0 && nums[mid - i - 1] == target) {
                    i++;
                }
                ans[0] = mid - i;

                int j = 0;
                while (mid + j + 1 < size && nums[mid + j + 1] == target) {
                    j++;
                }
                ans[1] = mid + j;
                return ans;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }
        }
        return ans;
    }
}
