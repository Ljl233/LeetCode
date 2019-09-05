package sort;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] a = new int[1001];
        int[] res = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            a[arr1[i]]++;
        }
        int ind = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (a[arr2[i]] > 0) {
                res[++ind] = arr2[i];
                a[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (a[i] > 0) {
                res[++ind] = i;
                a[i]--;
            }
        }
        return res;
    }
}