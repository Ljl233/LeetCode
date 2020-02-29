package greed;

import org.junit.jupiter.api.Test;

public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        if (length <= 2) return true;
        int count = 0;

        for (int i = 1; i < length; i++) {

            if (nums[i] >= nums[i - 1]) continue;
            count++;

            if (i > 1 && nums[i - 2] > nums[i])
                nums[i] = nums[i - 1];
            else
                nums[i - 1] = nums[i];

        }
        return count <= 1;
    }

    @Test
    void test() {
        int[] nums = new int[]{4, 2, 1};
        if (checkPossibility(nums)) {
            System.out.println("true");
        }
    }
}
