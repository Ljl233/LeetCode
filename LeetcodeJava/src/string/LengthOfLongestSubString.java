package string;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int ans = 0, i = 0, j = 0;
        while (j != len) {

            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }

        }
        return ans;
    }
}
