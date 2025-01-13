import java.lang.String;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MessageAuthenticator {
    public static byte[] authenticateMessage(byte[] message, byte[] password) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(password, "HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(message);
    }

	public static void main(String[] args) {
	}
}