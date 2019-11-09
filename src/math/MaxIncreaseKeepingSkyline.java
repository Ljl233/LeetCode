package math;

public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        //int[0] 为每行最大值，int[1]为每列最大值
        int[] rawMax = new int[N];
        int[] columns = new int[N];
        int[][] skyline = new int[2][N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rawMax[i] = Math.max(rawMax[i], grid[i][j]);
                columns[j] = Math.max(columns[j], grid[i][j]);

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += Math.min(rawMax[i], columns[j]) - grid[i][j];
            }
        }

        return ans;
    }
}
