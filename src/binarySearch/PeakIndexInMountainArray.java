package binarySearch;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (A[mid] > A[mid + 1] && A[mid - 1] > A[mid]) {
                right = mid - 1;
            } else if (A[mid] < A[mid + 1] && A[mid - 1] < A[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
