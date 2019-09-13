package arraylist;

public class Test {
    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] a = {1,1,2};
        r.removeDuplicates(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
