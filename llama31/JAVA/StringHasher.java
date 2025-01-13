import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class StringHasher {
    public static long hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
        return bytesToLong(hashBytes);
    }

    private static long bytesToLong(byte[] bytes) {
        long hash = 0;
        for (byte b : bytes) {
            hash = (hash << 8) | (b & 0xFF);
        }
        return hash;
    }

	public static void main(String[] args) {
	}
}