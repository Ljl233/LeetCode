package sort;

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 97]++;
        }
        for (int i = 0; i < s.length(); i++) {
            b[t.charAt(i) - 97]++;
        }
        return Arrays.equals(a, b);
    }
}
