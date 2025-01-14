import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class TripleDESTest {

    public static void main(String[] args) {
        String text = "kyle boon";

        byte[] codedtext = new TripleDESTest().encrypt(text);
        String decodedtext = new TripleDESTest().decrypt(codedtext);

        System.out.println(Base64.getEncoder().encodeToString(codedtext));
        System.out.println(decodedtext);
    }

    public byte[] encrypt(String message) {
        try {
            final MessageDigest md = MessageDigest.getInstance("md5");
            final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
            final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            for (int j = 0, k = 16; j < 8;) {
                keyBytes[k++] = keyBytes[j++];
            }

            final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
            final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);

            final byte[] plainTextBytes = message.getBytes("utf-8");
            return cipher.doFinal(plainTextBytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String decrypt(byte[] message) {
        try {
            final MessageDigest md = MessageDigest.getInstance("md5");
            final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
            final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            for (int j = 0, k = 16; j < 8;) {
                keyBytes[k++] = keyBytes[j++];
            }

            final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
            final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            decipher.init(Cipher.DECRYPT_MODE, key, iv);

            final byte[] plainText = decipher.doFinal(message);
            return new String(plainText, "utf-8");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}