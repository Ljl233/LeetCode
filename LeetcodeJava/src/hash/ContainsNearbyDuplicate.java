package hash;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!hashMap.containsKey(nums[i])) {
//                hashMap.put(nums[i], i);
//            } else {
//                if (Math.abs(i - hashMap.get(nums[i])) <= k) {
//                    return true;
//                } else {
//                    hashMap.put(nums[i], i);
//                }
//            }
//        }
//        return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
        }
        return false;
    }
}
