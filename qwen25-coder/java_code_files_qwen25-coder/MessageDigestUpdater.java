import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestUpdater {
    public static void main(String[] args) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String string = "your_string_here";
            md5.update(string.getBytes(StandardCharsets.ISO_8859_1));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}