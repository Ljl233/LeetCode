package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    boolean isPrimes(int n) {
        if (n == 2 || n == 3) return true;
        if ((n + 1) % 6 == 0 || (n - 1) % 6 == 0) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        } else
            return false;
    }

//Eratosthenes sieve厄拉多塞筛法

    public int eratosthenes(int n) {
        if (n <= 2) return 0;
        if (n == 3) return 1;
        int s = (int) Math.sqrt(n);

        List<Integer> list = new ArrayList<>();

        int count = 0;

        for (int i = 2; i <= s; i++) {
            if (isPrimes(i)) list.add(i);
            count++;
            //  System.out.println(i);
        }
        //    System.out.println();
        for (int i = s + 1; i < n; i++) {
            boolean sign = false;

            for (int j = 0; j < list.size(); j++) {
                if (i % list.get(j) == 0) {
                    sign = false;
                    break;
                } else sign = true;
            }
            if (sign) {
                //         System.out.println(i);
                count++;
            }
        }
        return count;

    }
}
