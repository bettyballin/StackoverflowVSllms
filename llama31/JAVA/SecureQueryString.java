import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SecureQueryString {
    private static final String SECRET_KEY = "your_secret_key_here"; // 128-bit key
    private static final int EXPIRATION_DAYS = 3;

    public static String encrypt(String queryString) throws Exception {
        // Generate a random initialization vector (IV)
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[16];
        random.nextBytes(iv);

        // Create an AES cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128, random);
        SecretKey key = keyGen.generateKey();
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        // Encrypt the query string
        byte[] encryptedBytes = cipher.doFinal(queryString.getBytes("UTF-8"));

        // Return the encrypted query string as a base64-encoded string
        return Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String generateToken(String identifier) {
        // Create a JWT token that expires after 3 days
        return Jwts.builder()
                .setSubject(identifier)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DAYS * 24 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static void main(String[] args) throws Exception {
        String queryString = "user=123&foo=bar";
        String encryptedQueryString = encrypt(queryString);
        String token = generateToken("user123");

        System.out.println("Encrypted query string: " + encryptedQueryString);
        System.out.println("Token: " + token);
    }
}