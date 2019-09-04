package NQueen;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] result = new int[n];

        findQueen(res, 0, n, result);
        return res;
    }

    private void findQueen(List list, int raw, int n, int[] result) {

        if (raw == n) {
            list.add(getQueenList(result, n));
        } else {
            for (int i = 0; i < n; i++) {
                if (isPosition(raw, i, result)) {
                    result[raw] = i;
                    findQueen(list, raw + 1, n, result);
                }
            }
        }
    }

    private boolean isPosition(int raw, int i, int[] result) {
        for (int j = raw - 1; j >= 0; j--) {
            if (i == result[j]) return false;
            if (i + raw == j + result[j]) return false;
            if (i - raw == result[j]-j) return false;

        }
        return true;

    }

    private List<String> getQueenList(int[] result, int n) {
        List<String> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < result[i]; j++) {
                stringBuilder.append(".");
            }
            stringBuilder.append("Q");
            for (int j = result[i] + 1; j < n; j++) {
                stringBuilder.append(".");
            }
            r.add(stringBuilder.toString());
        }
        return r;
    }

}