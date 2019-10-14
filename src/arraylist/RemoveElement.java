package arraylist;


/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len<=0)return 0;

        int l = len;
        int i = 0;
        while (l > 0) {
            if (nums[i] == val) {
                remove(nums, i, len);
                len--;
            } else {
                i++;
            }
            l--;
        }
        return len;

    }

    private static void remove(int[] nums, int index, int length) {
        for (int i = index; i < length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
