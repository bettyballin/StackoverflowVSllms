import java.lang.String;
// Example of using AES encryption in Java
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
    private static final String ALGORITHM = "AES";
    private SecretKeySpec secretKey;

    public Encryptor(byte[] key) {
        this.secretKey = new SecretKeySpec(key, ALGORITHM);
    }

    public byte[] encrypt(byte[] data) throws Exception {
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, secretKey);
        return c.doFinal(data);
    }

    public static void main(String[] args) {
    }
}