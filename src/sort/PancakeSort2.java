package sort;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort2 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == i + 1) continue;
            for (int j = 0; ; j++) {
                if (A[j] == i + 1) {
                    reverse(A, j);
                    list.add(j + 1);
                    reverse(A, i);
                    list.add(i+1);
                    break;
                }
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
}
