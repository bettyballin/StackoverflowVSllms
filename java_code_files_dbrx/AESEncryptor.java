import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptor {
    public byte[] encrypt(byte[] key, String data) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data.getBytes());
    }
    public static void main(String[] args) {
    }
}