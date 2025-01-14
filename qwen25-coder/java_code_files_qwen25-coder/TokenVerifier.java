import java.lang.String;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class TokenVerifier {
    public static boolean verifyToken(String token, String signatureBase64, byte[] publicKeyBytes) throws Exception {
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes));
        Signature signatureInstance = Signature.getInstance("SHA256withRSA");
        signatureInstance.initVerify(publicKey);
        signatureInstance.update(token.getBytes());
        
        byte[] signature = Base64.getDecoder().decode(signatureBase64);
        return signatureInstance.verify(signature);
    }

	public static void main(String[] args) {
	}
}