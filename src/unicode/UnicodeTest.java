package unicode;

public class UnicodeTest {
    public static void main(String[] args) {
        String s="Android\\u8fdb\\u9636\\u5b66\\u4e60";
        String u=TransCodingUtil.unicodeToString(s);
        System.out.println(u);
        char s2= (char) Integer.parseInt("8fdb", 16);
        System.out.println(s2);
    }
}
