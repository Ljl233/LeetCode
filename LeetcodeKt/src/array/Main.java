package array;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static int movingCount(int m, int n, int k) {
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int x = i;
                int y = j;

                while (x != 0) {
                    sum += x % 10;
                    x = x / 10;
                }
                while (y != 0) {
                    sum += y % 10;
                    y = y / 10;
                }
                if (sum <= k) {
                    result++;
                } else {
                    break;
                }
            }
            int sum = 0;
            int x = i;
            while (x != 0) {
                sum += x % 10;
                x = x / 10;
            }
            if(sum>k){
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }
}