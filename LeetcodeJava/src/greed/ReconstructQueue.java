package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length != 2)
            return new int[0][0];
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };

        Arrays.sort(people, comparator);

        List<int[]> list = new ArrayList<>(people.length);
        for (int[] p : people) {
            list.add(p[1], p);
        }


        return list.toArray(new int[list.size()][]);
    }
}
