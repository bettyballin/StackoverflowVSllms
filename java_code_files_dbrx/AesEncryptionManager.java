import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesEncryptionManager {

    private static final byte[] YOUR_SECRET_KEY = {
        0x00, 0x01, 0x02, 0x03,
        0x04, 0x05, 0x06, 0x07,
        0x08, 0x09, 0x0A, 0x0B,
        0x0C, 0x0D, 0x0E, 0x0F
    }; // replace YOUR_SECRET_KEY with actual bytes here

    SecretKeySpec sks = new SecretKeySpec(YOUR_SECRET_KEY, "AES");
    Cipher c;

    {
        try {
            c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, sks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}