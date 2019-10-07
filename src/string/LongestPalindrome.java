package string;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int maxLength = 0;
        String ans;
        int S = 0, E = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expendFromCenter(s, i, i);
            int len2 = expendFromCenter(s, i, i + 1);

            int len = Math.max(len1, len2);


            if (len > maxLength) {
                maxLength = len;
                S = i - (len - 1) / 2;
                E = i + len / 2;
            }
        }

        ans = s.substring(S, E + 1);
        return ans;
    }

    public int expendFromCenter(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}
