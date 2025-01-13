import java.lang.String;

public class UrlEncoder {
    public static String encodeByteArray(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%%%02X", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // You may want to add some test cases here to test the encodeByteArray method
    }
}