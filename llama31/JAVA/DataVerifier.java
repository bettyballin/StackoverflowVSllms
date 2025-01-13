import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataVerifier {
    public static String calculateChecksum(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md.digest(data.getBytes());
        return bytesToHex(bytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

	public static void main(String[] args) {
	}
}