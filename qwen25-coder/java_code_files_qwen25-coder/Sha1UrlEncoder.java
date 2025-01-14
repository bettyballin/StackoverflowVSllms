import java.lang.String;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Sha1UrlEncoder {
    public static String encodeSha1ToUrl(String hexString) throws Exception {
        // Convert the hex string back to a byte array
        byte[] bytes = hexStringToByteArray(hexString);

        // URL-encode each byte into a percent-encoded format
        StringBuilder encodedString = new StringBuilder();
        for (byte b : bytes) {
            // Format each byte as %HH, where HH are the hexadecimal digits of the byte
            String encodedByte = String.format("%%%02X", b);
            encodedString.append(encodedByte);
        }

        return encodedString.toString();
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        String hexString = "9a81333c1b16e4a83c10f3052c1590aadf5e2e20";
        String encodedSha1 = encodeSha1ToUrl(hexString);
        System.out.println(encodedSha1); // Output: %9A%81%33%3C%1B%16%E4%A8%3C%10%F3%05%2C%15%90%AA%DF%5E.%20
    }
}