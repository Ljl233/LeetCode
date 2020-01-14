package greed;

public class Test {
    public static void main(String[] args) {
//        LastStoneWeight l = new LastStoneWeight();
//        int ans = l.lastStoneWeight(new int[]{3,7,2});
        LemonadeChange l = new LemonadeChange();
        int ans = l.lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5}) ? 1 : 0;
        System.out.println(ans);
    }
}
