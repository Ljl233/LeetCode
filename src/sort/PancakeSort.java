package sort;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    int max;

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        max = A.length;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            index = findMax(A, i);
            if (index != A.length - i - 1) {
                if (index != 0) {
                    reverse(A, index);
                    list.add(index + 1);
                }

                reverse(A, A.length - i - 1);
                list.add(A.length - i);
            }
        }
        return list;

    }

    private void reverse(int[] a, int index) {
        int temp;
        for (int i = 0; i < (index + 1) / 2; i++) {
            temp = a[i];
            a[i] = a[index - i];
            a[index - i] = temp;
        }

    }

    private int findMax(int[] a, int cur) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                max--;
                index = i;
                break;
            }
        }
        return index;
    }

}
