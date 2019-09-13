package arraylist;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }

        }
        return i;
    }
}
