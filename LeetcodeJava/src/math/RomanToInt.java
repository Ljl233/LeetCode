package math;

public class RomanToInt {
    public int romanToInt(String s) {
        int len = s.length();
        int[] roman = new int[len];
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            switch (chars[i]) {
                case 'I':
                    roman[i] = 1;
                    break;
                case 'V':
                    roman[i] = 5;
                    break;
                case 'X':
                    roman[i] = 10;
                    break;
                case 'L':
                    roman[i] = 50;
                    break;
                case 'C':
                    roman[i] = 100;
                    break;
                case 'D':
                    roman[i] = 500;
                    break;
                case 'M':
                    roman[i] = 1000;
                    break;
            }
        }
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            if (roman[i] < roman[i + 1]) ans -= roman[i];
            else ans += roman[i];
        }
        ans += roman[len - 1];
        return ans;

    }
}
