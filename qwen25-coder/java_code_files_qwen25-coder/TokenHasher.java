import java.lang.String;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class TokenHasher {
    public String hashToken(String token) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        md.update(token.getBytes());
        byte[] hashedBytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : salt) {
            sb.append(String.format("%02x", b));
        }
        sb.append(":");
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString(); // Salt:Hash pair
    }

    public boolean verifyToken(String storedSaltedHash, String tokenToVerify) throws Exception {
        String[] parts = storedSaltedHash.split(":");
        byte[] salt = hexStringToByteArray(parts[0]);
        String expectedHash = parts[1];

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        md.update(tokenToVerify.getBytes());
        byte[] calculatedHashBytes = md.digest();

        return expectedHash.equals(bytesToHex(calculatedHashBytes));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
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

	public static void main(String[] args) {
	}
}