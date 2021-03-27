package array;

import java.util.Scanner;

public class Backup {
    public static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long w = scanner.nextLong();
        int[] v = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
            sum += v[i];
        }
        if (sum <= w) {
            System.out.println((int) Math.pow(2, n));
        } else {
            dfs(0, 0, n, w, v);
            System.out.println(res + 1);
        }
    }

    static void dfs(int cur, long sum, int n, long w, int[] v) {
        if (cur >= n) return;
        if (sum > w) {
            return;
        }
        dfs(cur + 1, sum, n, w, v);
        if (sum + v[cur] <= w) {
            res++;
            dfs(cur + 1, sum + v[cur], n, w, v);
        }
    }
}
/*
使用枚举的方法，枚举方法分为迭代和递归，显然这道题使用递归更加方便。
 */