package greed;

public class MatrixScore {
    public int matrixScore(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int ans = 0;

        for (int c = 0; c < C; c++) {
            int col = 0;

            for (int r = 0; r < R; r++) {
                col += A[r][c] ^ A[r][0];
            }
            ans += Math.max(col, R - col) * (1 << (C - 1 - c));
        }
        return ans;
    }
}
