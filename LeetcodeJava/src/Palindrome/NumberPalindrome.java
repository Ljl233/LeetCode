package Palindrome;

public class NumberPalindrome {
    boolean isPalindrome(int x) {
        String string = x+"";
        char[] chars = string.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) return false;
        }
        return true;
    }
}
