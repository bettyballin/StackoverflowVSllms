import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class HybridEncryptionUtil {
    public static byte[] wrapWithRSA(PublicKey publicKey, String alias, SecretKey key) throws Exception {
        Cipher rsa = Cipher.getInstance("RSA/None/OAEPwithSHA1andMGF1Padding", "BC");
        rsa.init(Cipher.WRAP_MODE, publicKey);
        return rsa.wrap(key); // symmetric secret key wrapped with RSA
    }

    public static byte[] encryptDataWithAES(SecretKey aesKey, byte[] iv, byte[] data) throws Exception {
        Cipher c = Cipher.getInstance("AES/CTR/NoPadding", "BC"); // use AES according to your preference (CBC or other modes)
        IvParameterSpec ivSpec = new IvParameterSpec(iv); // initialize with IV / NONCE when necessary for chosen algorithm.
        c.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);
        return c.doFinal(data); // encrypt data using AES.
    }

    public static void main(String[] args) {
    }
}