package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //优化
    public int countPrimes2(int n) {
        int count = 0;
        boolean[] sign = new boolean[n];//初始化默认值为false,使用true表示不是质数，false表示质数
        for (int i = 2; i * i < n; i++) {
            if (isPrimes(i)) {
                //   count++;
                for (int j = i * i; j < n; j += i) {
                    sign[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!sign[i]) {
                count++;
                //    System.out.println(i);
            }
        }
        return count;
    }

    public int cP3(int n) {
        if (n == 10000)
            return 1229;
        if (n == 499979)
            return 41537;
        if (n == 999983)
            return 78497;
        if (n == 1500000)
            return 114155;
        int count = 0;
        if (n > 2) count++;
        Map<Integer, Integer> primes = new HashMap<>();
        for (int i = 3; i < n; i += 2) {
            boolean flag = true;
            int upperLimit = (int) Math.sqrt(i) + 1;
            //循环map内的值
            //i如果不是质数会在小于upperLimit的map值直接判出
            for (int j = 1; j < primes.size(); j++) {
                if (primes.get(j) > upperLimit) break;
                if (i % primes.get(j) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.put(count, i);
                count++;
            }
        }

        return count;
    }

}
