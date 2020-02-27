package greed;

import org.junit.jupiter.api.Test;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int zero = 0;
        boolean first = true;
        int length = flowerbed.length;
        if (length == 0) return false;
        if (length == 1 && flowerbed[0] == 0) return true;
        for (int value : flowerbed) {
            if (value == 0) zero++;
            else {
                if (first) {
                    count += zero / 2;
                    first = false;
                } else {
                    count += (zero - 1) / 2;
                }
                zero = 0;
            }
        }
        if (first) count += (zero + 1) / 2;
        else
            count += zero / 2;
        return n <= count;
    }

    @Test
    void test() {
        int[] flowerbed = new int[]{
                1, 0, 0, 0, 1
        };
        if (canPlaceFlowers(flowerbed, 2))
            System.out.println("can place");
    }


}
