package dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LuckyNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
        int[] nums = new int[strings.length];
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
            sum += nums[i];
        }
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = 1;
            for (int j = 0; j < sum + 1; j++) {
                if (dp[j] == 1 && j > nums[i]) {
                    dp[j - nums[i]] = 1;
                }
            }
        }
        for (int j = sum; j >= 0; j--) {
            if (dp[j] == 1 && j % 7 == 0) {
                System.out.println(j);
                return;
            }
        }
        System.out.println(-1);
    }
}

/*
获取所有可能的和值。
 */