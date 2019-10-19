package binarySearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        SearchInsert searchInsert = new SearchInsert();
        int ans = searchInsert.searchInsert(nums, target);

        System.out.println(ans);

    }
}
