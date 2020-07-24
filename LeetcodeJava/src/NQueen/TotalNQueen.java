package NQueen;

import java.util.List;

public class TotalNQueen {


    private static int r = 0;

    public int totalNQueens(int n) {
        int[] result = new int[n];
        int[] r = new int[1];
        findQueens(r, 0, n, result);
        return r[0];
    }

    private void findQueens(int[] r, int raw, int n, int[] result) {
        if (raw == n) r[0]++;
        else {
            for (int i = 0; i < n; i++) {
                if (isQueens(i, raw, result)) {
                    result[raw] = i;
                    findQueens(r, raw, n, result);

                }
            }
        }
    }

    private boolean isQueens(int column, int raw,  int[] result) {
        for (int i = raw - 1; i >= 0; i--) {
            if (result[i] == column) return false;
            if (i + result[i] == raw + column) return false;
            if (i - result[i] == raw - column) return false;

        }
        return true;
    }

}
