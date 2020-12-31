package binarysearch

/*
#153. 寻找旋转排序数组中的最小值
 */
class FindMin {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var l = 0
        var r = nums.size - 1

        if (nums[0] < nums[r])
            return nums[0]

        while (l <= r) {
            val mid = (l + r) / 2

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1]
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid]
            }

            if (nums[0] < nums[mid]) {
                l = mid + 1
            } else {
                r = mid - 1
            }

        }
        return -1
    }
}

/*
public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int middle = (left + right) / 2;
        if (nums[middle] < nums[right]) {
            // middle可能是最小值
            right = middle;
        } else {
            // middle肯定不是最小值
            left = middle + 1;
        }
    }
    return nums[left];
}
 */