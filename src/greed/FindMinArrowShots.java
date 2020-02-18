package greed;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1, length = points.length, end = points[0][1];

        for (int i = 1; i < length; i++) {
            if (points[i][0] >= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }
}
