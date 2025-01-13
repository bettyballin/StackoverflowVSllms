import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecureEncrypt_1 {
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws Exception {
        byte[] data = "Hello, World!".getBytes();
        byte[] key = "mysecretkey1234".getBytes();
        byte[] encrypted = encrypt(data, key);
        System.out.println(java.util.Arrays.toString(encrypted));
    }
}