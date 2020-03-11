package athority;

public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int s = 0;
        for (int i : A) {
            s += i;
        }
        if (s % 3 != 0) return false;

        int target = s / 3;
        int n = A.length, i = 0, cur = 0;
        while (i < n) {
            cur += A[i];
            if (cur == target) {
                break;
            }
            i++;
        }
        if (cur != target) return false;

        int j = i + 1;
        cur = 0;
        while (j + 1 < n) {
            cur += A[j];
            if (cur == target) break;
            j++;
        }
        return cur == target;

    }
}
