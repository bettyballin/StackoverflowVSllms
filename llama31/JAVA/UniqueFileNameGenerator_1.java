import java.lang.Integer;
import java.lang.String;
import java.security.SecureRandom;

public class UniqueFileNameGenerator_1 {
    public static String generateUniqueFileName() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String uniqueFileName = bytesToHex(bytes);
        return uniqueFileName;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

	public static void main(String[] args) {
	}
}