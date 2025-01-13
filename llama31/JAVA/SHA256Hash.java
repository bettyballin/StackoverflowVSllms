import java.lang.String;
import java.security.MessageDigest;

public class SHA256Hash {
    public static byte[] hash(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data);
    }

	public static void main(String[] args) {
	}
}