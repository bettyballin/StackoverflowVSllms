import java.lang.String;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class LicenseUtility {

    public static byte[] signMessageSHA512WithPKCS8(byte[] message, PrivateKey privateKey) throws Exception {
        Signature instance = Signature.getInstance("SHA512withRSA");
        instance.initSign(privateKey);
        instance.update(message);

        return instance.sign();
    }

    public static boolean verifySignatureSHA512WithPKCS8(byte[] signature, byte[] message, PublicKey publicKey) throws Exception {
        Signature instance = Signature.getInstance("SHA512withRSA");
        instance.initVerify(publicKey);
        instance.update(message);

        return instance.verify(signature);
    }

	public static void main(String[] args) {
	}
}