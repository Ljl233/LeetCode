package sort;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0, j = 1; j < A.length && i < A.length; ) {
            if ((A[i] & 1) != 0 && (A[j] & 1) == 0) {
                int a = A[i];
                A[i] = A[j];
                A[j] = a;
            }

            if ((A[i] & 1)== 0) i += 2;
            if ((A[j] & 1)!= 0) j += 2;
        }
        return A;
    }
}
