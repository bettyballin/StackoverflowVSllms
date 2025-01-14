import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class AesGcmExample {
    public static byte[] encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[12];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());

        byte[] combinedOut = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, combinedOut, 0, iv.length);
        System.arraycopy(cipherText, 0, combinedOut, iv.length, cipherText.length);

        return combinedOut;
    }

    public static String decrypt(byte[] cipherBytes, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        IvParameterSpec ivSpec = new IvParameterSpec(cipherBytes, 0, 12);
        byte[] text = new byte[cipherBytes.length - 12];
        System.arraycopy(cipherBytes, 12, text, 0, cipherBytes.length - 12);

        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        return new String(cipher.doFinal(text));
    }

    public static SecretKey generateRandomAesKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

	public static void main(String[] args) {
	}
}