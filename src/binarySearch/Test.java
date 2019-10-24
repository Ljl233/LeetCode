package binarySearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,9,6,9,3,8,9,7,1};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
//        int[] ans = Intersect.intersect(nums, nums2);
        int target = 9;
//        SearchInsert searchInsert = new SearchInsert();
//        int ans = searchInsert.searchInsert(nums, target);
//        int ans=new MySqrt().mySqrt(target);

//        int[] ans = new TwoSum().twoSum(nums, target);

        System.out.println(FindDuplicate.findDuplicate(nums));

    }
}
