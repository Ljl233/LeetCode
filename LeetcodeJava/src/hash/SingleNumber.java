package hash;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        set = map.keySet();
        return (int) set.toArray()[0];
    }
}
