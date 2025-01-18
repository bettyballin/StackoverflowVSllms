import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        // Generate 32 random bytes for salt
        byte[] salt = new byte[32];
        new SecureRandom().nextBytes(salt);
        String strSalt = bytesToHex(salt); // hex form of the given salt

        String id = "someId";  // Replace with actual id value

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest((id + strSalt).getBytes(StandardCharsets.UTF_8)); // hash created

        SecretKey key = new SecretKeySpec("my_secret_key".getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key); // creates the secret key object from byte[] and a String constant "AES"

        // Concatenate hash and salt in hex form
        String dataToEncrypt = bytesToHex(hash) + strSalt;
        byte[] encryptedHashAndSalt = cipher.doFinal(dataToEncrypt.getBytes(StandardCharsets.UTF_8)); // create an encrypted string which contains both hash of id and salt

        String urlSafeEncryptedValue = URLEncoder.encode(bytesToHex(encryptedHashAndSalt), "UTF-8"); // URL safe form of byte[]

        System.out.println("Encrypted Value: " + urlSafeEncryptedValue);
    }

    // Utility method to convert byte[] to hex string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}