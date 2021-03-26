package array;

import java.util.Scanner;
import java.util.Arrays;

public class Alarms {
    public static void main(String[] ags) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] alarms = new int[n];
        for (int i = 0; i < n; i++) {
            int hi = scanner.nextInt();
            int mi = scanner.nextInt();
            alarms[i] = hi * 60 + mi;
        }
        int x = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int time = A * 60 + B;
        Arrays.sort(alarms);
        for (int i = n - 1; i >= 0; i--) {
            if (alarms[i] + x <= time) {
                System.out.println(alarms[i] / 60 + " " + alarms[i] % 60);
                break;
            }
        }
    }
}

/*
时间的排序转化成分钟进行排序最为方便
 */