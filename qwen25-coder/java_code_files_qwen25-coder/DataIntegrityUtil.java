import java.lang.String;
import java.security.MessageDigest;
import java.util.Base64;

public class DataIntegrityUtil {

    public static String generateChecksum(byte[] data) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data);
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyChecksum(byte[] originalData, String receivedChecksum) throws Exception {
        String recalculatedChecksum = generateChecksum(originalData);
        return recalculatedChecksum.equals(receivedChecksum);
    }

	public static void main(String[] args) {
	}
}