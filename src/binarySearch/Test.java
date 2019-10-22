package binarySearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
//        SearchInsert searchInsert = new SearchInsert();
//        int ans = searchInsert.searchInsert(nums, target);
//        int ans=new MySqrt().mySqrt(target);

//        int[] ans = new TwoSum().twoSum(nums, target);

        System.out.println(Search.search(nums,target));

    }
}
