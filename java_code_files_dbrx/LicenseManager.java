import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class LicenseManager {
    private static final String ALGORITHM = "RSA";

    public static void main(String... args) throws Exception {
        KeyPair keyPair = createKeyPair(); // Generate a new RSA keypair (Public/Private keys)
        byte[] randomData = generateRandomData(); // Simulate some data to be used for the license.
        String privateLicense = createPrivateLicense(keyPair, randomData); // The 'private' encrypted version of our 'license'.
        boolean isValid = validateLicenseKey(keyPair, privateLicense);  // Check if this key is valid according to our rules.

        System.out.println("License is valid: " + isValid);
    }

    public static KeyPair createKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    public static byte[] generateRandomData() {
        byte[] randomData = new byte[128];
        new SecureRandom().nextBytes(randomData);
        return randomData;
    }

    public static String createPrivateLicense(KeyPair keyPair, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
        byte[] encryptedData = cipher.doFinal(data);
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static boolean validateLicenseKey(KeyPair keyPair, String privateLicense) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(privateLicense));

        // Assuming the license is valid if decrypted data is not empty
        return decryptedData.length > 0;
    }
}