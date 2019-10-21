package binarySearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,3,4};
        int target = 0;
//        SearchInsert searchInsert = new SearchInsert();
//        int ans = searchInsert.searchInsert(nums, target);
//        int ans=new MySqrt().mySqrt(target);

        int[] ans = new TwoSum().twoSum(nums, target);

        System.out.println(ans[0] + "      " + ans[1]);

    }
}
