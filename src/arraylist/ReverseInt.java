package arraylist;

import java.util.ArrayList;

public class ReverseInt {
    public int reverse(int x) {
        int sign = 1, size = 0;
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        int r = 0;
        int ans = 0;
        while (x >= 10) {
            r = x % 10;
            ans = ans * 10 + r;
            x = x / 10;
        }

        if (sign > 0) {
            if (ans > (2147483647 - x) / 10.0) {
                sign = 0;
            }
        } else {
            if (ans + 0.1 > (2147483647 - x) / 10.0) {
                sign = 0;
            }
        }
        ans = ans * 10 + x;
        return ans * sign;
    }
}
