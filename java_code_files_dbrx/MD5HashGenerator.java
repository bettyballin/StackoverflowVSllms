import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class MD5HashGenerator {
    public static String getMD5Hash(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = string.getBytes(StandardCharsets.UTF_8);  // convert to UTF-8 encoding if necessary
            md.update(bytes, 0, bytes.length);
            byte[] digest = md.digest();

            return new BigInteger(1, digest).toString(16);  // converts the message digest to a hexadecimal value
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("The MD5 digest algorithm is not available");
        }
    }
    public static void main(String[] args) {
    }
}