import java.lang.String;
public class StringEncoderDecoder {
    private static final char DELIMITER = '|';

    public static String encode(String[] items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if (i > 0) sb.append(DELIMITER);
            sb.append(items[i]);
        }
        return sb.toString();
    }

    public static String[] decode(String encoded) {
        return encoded.split("\\" + DELIMITER, -1);
    }

    public static void main(String[] args) {
        String[] items = {"apple", "banana|with|pipes", "cherry"};
        String encoded = encode(items);
        System.out.println("Encoded: " + encoded);

        String[] decodedItems = decode(encoded);
        System.out.println("Decoded:");
        for (String item : decodedItems) {
            System.out.println(item);
        }
    }
}