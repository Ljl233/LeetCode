package unicode;

public class TransCodingUtil {
    public static String unicodeToString(final String dataStr) {
        int start = 0;
        int end = 0;
        char letter = 0;
        final StringBuffer buffer = new StringBuffer();


        while (start < dataStr.length() && end >= 0) {

            end = dataStr.indexOf("\\u", start);
            String charStr1 = "";
            if (end != -1) {
                charStr1 = dataStr.substring(start, end);
                buffer.append(charStr1);
            }

            start = end + 2;
            end = dataStr.indexOf("\\u", start);
            String unicode1 = dataStr.substring(start, start + 4);

            letter = (char) Integer.parseInt(unicode1, 16);
            buffer.append(letter);
            start = end;
        }
        return buffer.toString();
    }
}
