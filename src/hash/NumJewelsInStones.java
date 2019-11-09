package hash;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        char[] js = J.toCharArray();
        char[] ss = S.toCharArray();
        int[] array = new int[58];
        for (int i = 0; i < ss.length; i++) {
            array[ss[i]-65]++;
        }
        int ans = 0;
        for (int i = 0; i < js.length; i++) {
            ans += array[js[i]-65];
        }
        return ans;
    }
}
