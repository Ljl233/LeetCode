package binarySearch;

public class MySqrt {
    public int mySqrt(int x) {
        long left = 1, right = x / 2;
        while (left < right) {
            long mid = (left + right+1) / 2;
            long square = mid * mid;
            if (square > x) {
                right = mid-1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}