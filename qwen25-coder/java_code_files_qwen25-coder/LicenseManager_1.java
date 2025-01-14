import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class LicenseManager_1 {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = new byte[]{ // Use a secure method to generate and handle this key
            0x01, 0x23, 0x45, 0x67, (byte) 0x89, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF,
            0xFE, (byte) 0xDC, (byte) 0xBA, (byte) 0x98, 0x76, 0x54, 0x32, 0x10
    };

    public String encrypt(String licenseKey) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(licenseKey.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedLicense) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = Base64.getDecoder().decode(encryptedLicense);
        return new String(cipher.doFinal(decoded));
    }

    public boolean validateLicense(String licenseKey) {
        // Here you would add the logic to check for expiration, digital signature, etc.
        return true;
    }

    public static void main(String[] args) {
    }
}