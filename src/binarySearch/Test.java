package binarySearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 4;
//        SearchInsert searchInsert = new SearchInsert();
//        int ans = searchInsert.searchInsert(nums, target);
        int ans=new MySqrt().mySqrt(target);

        System.out.println(ans);

    }
}
