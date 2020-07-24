package athority;

import org.junit.jupiter.api.Test;

public class DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int all = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
//        int all = (int) Math.sqrt(candies * 2);

        int row = all / num_people;//row 次完整的
        int last = all % num_people;//最后一次有几个小孩得到了糖果

        if (row > 0)
            for (int j = 0; j < num_people; j++) {
                ans[j] += row * (j + 1) + num_people * row * (row - 1) / 2;
            }

        for (int i = 0; i < last ; i++) {
            ans[i] += i + 1 + num_people * row;
        }


        ans[last] += candies - all * (all + 1) / 2;
        return ans;
    }

    @Test
    void test() {
        distributeCandies(7, 4);
    }
}
