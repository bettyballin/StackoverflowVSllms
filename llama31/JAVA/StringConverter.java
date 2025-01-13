import java.io.UnsupportedEncodingException;

public class StringConverter {
    String windows1252String = "Παράδειγμα"; // Greek characters
    String unicodeString;

    public StringConverter() throws UnsupportedEncodingException {
        unicodeString = new String(windows1252String.getBytes("windows-1252"), "UTF-8");
    }

    public static void main(String[] args) {
        try {
            StringConverter converter = new StringConverter();
            System.out.println(converter.unicodeString);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding exception: " + e.getMessage());
        }
    }
}