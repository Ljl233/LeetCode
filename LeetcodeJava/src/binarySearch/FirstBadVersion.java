package binarySearch;

public class FirstBadVersion {
    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
            return left;
//        if (n == 0) return 0;
//        if (n == 1) return isBadVersion(1) ? 1 : 0;
//
//        int left = 1;
//        int right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//
//            if (isTarget(mid) == 0) return mid;
//            else if (isTarget(mid) == -1) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//
//        if (left != n + 1 && isTarget(left) == 0) return left;
//        return 0;

    }

    int isTarget(int n) {
        if (n == 0 && isBadVersion(n)) return 0;
        else if (!isBadVersion(n - 1) && isBadVersion(n)) return 0;
        else if (!isBadVersion(n) && !isBadVersion(n - 1)) return -1;
        else return 1;
    }

    private boolean isBadVersion(int version) {

        return version >= 2147483647;
    }

}
