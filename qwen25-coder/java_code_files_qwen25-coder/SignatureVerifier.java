import java.lang.String;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureVerifier {
    public static boolean verifySignature(InputStream data, byte[] signatureBytes, PublicKey publicKey) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        // Initialize the Signature object
        Signature sig = Signature.getInstance("SHA1withRSA"); // Use appropriate algorithm if different
        sig.initVerify(publicKey);

        // Read and update the signature in chunks
        byte[] buffer = new byte[8192]; // 8KB buffer size, adjust as necessary
        int read;
        while ((read = data.read(buffer)) != -1) {
            sig.update(buffer, 0, read);
        }

        // Verify the signature
        return sig.verify(signatureBytes);
    }

	public static void main(String[] args) {
	}
}