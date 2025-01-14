import java.lang.String;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class TokenSigner {
    public static String signToken(String token, byte[] privateKeyBytes) throws Exception {
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
        Signature signatureInstance = Signature.getInstance("SHA256withRSA");
        signatureInstance.initSign(privateKey);
        signatureInstance.update(token.getBytes());
        return Base64.getEncoder().encodeToString(signatureInstance.sign());
    }

	public static void main(String[] args) {
	}
}