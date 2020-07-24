package arraylist;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int[] copy = nums.clone();
        List<Integer> list = new ArrayList<>();
        //     int[] a = new int[nums.length];
        int j = 0, k = 0;
        for (int i = 0; i < copy.length; i++) {

            if (!contains(list, copy[i])) {
                //  a[j] = copy[i];
                list.add(copy[i]);
                j++;
            } else {
                move(nums, k, copy.length-(k-j));
                k--;
            }
            k++;
        }
        return j;
    }

    private void move(int[] a, int index, int len) {
        for (int i = index; i < len-1; i++) {
            a[i] = a[i + 1];
        }
    }

    private boolean contains(List<Integer> list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) return true;
        }
        return false;
    }

    private boolean contains(int[] a, int num) {
        for (int value : a) {
            if (value == num) return true;
        }
        return false;
    }

}
