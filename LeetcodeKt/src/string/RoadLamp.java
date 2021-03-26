package string;

import java.util.Scanner;

public class RoadLamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int result = 0;
            for (int j = 0; j< n;j++){
                if (s.charAt(j)=='.'){
                    result++;
                    j+=2;
                }
            }
            System.out.println(result);
        }
    }
}

/*
将'.'的分布分为以下几种情况：
1. 1个'.'，放置一个路灯
2. 2个'.'，放置一个路灯
3. 3个'.'，放置一个路灯
4. 每三个连续的'.'，放置一个路灯，不足三个也需要放置1个路灯。
 */