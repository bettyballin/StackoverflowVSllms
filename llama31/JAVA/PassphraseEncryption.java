import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PassphraseEncryption {

    private static final String ALGORITHM = "PBEWithHMACSHA1AndAES_128";
    private static final int ITERATIONS = 1000;

    public static byte[] encrypt(String data, String passphrase) throws Exception {
        KeySpec keySpec = new PBEKeySpec(passphrase.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(new byte[]{}, ITERATIONS));

        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, String passphrase) throws Exception {
        KeySpec keySpec = new PBEKeySpec(passphrase.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(new byte[]{}, ITERATIONS));

        return new String(cipher.doFinal(data));
    }

    public static void main(String[] args) throws Exception {
        String data = "Hello, World!";
        String passphrase = "mysecretpassword";

        byte[] encrypted = encrypt(data, passphrase);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));

        String decrypted = decrypt(encrypted, passphrase);
        System.out.println("Decrypted: " + decrypted);
    }
}