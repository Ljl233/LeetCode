package binarySearch;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            int and = numbers[left] + numbers[right];
            if (and == target) break;
            if (and > target) right--;
            if (and < target) left++;
        }

        int[] ans = new int[2];
        ans[0] = left + 1;
        ans[1] = right + 1;
        return ans;
    }
}