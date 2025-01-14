import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashGenerator {

    public static String getMD5Hash(String string) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // Specify UTF-8 encoding
            md5.update(string.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md5.digest();

            return byteArrToHexString(digest);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    private static String byteArrToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();

        for (byte b : bytes) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }
}