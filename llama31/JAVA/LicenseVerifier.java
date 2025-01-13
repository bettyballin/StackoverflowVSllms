import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;

public class LicenseVerifier {
    private static final String SECRET_KEY = "your_secret_key_here"; // 16 bytes (128 bits) for AES encryption
    private static final String LICENSE_KEY_FILE = "license.key";

    public boolean verifyLicense() {
        try {
            // Compute hardware fingerprint
            String hardwareFingerprint = getHardwareFingerprint();

            // Load encrypted license key
            String encryptedLicenseKey = loadLicenseKey();

            // Decrypt license key
            String decryptedLicenseKey = decryptLicenseKey(encryptedLicenseKey);

            // Compare hardware fingerprint with license key
            return hardwareFingerprint.equals(decryptedLicenseKey);
        } catch (Exception e) {
            System.err.println("Verification failed: " + e.getMessage());
            return false;
        }
    }

    private String getHardwareFingerprint() throws SocketException {
        // Simulate getting a hardware fingerprint (e.g., MAC address for simplicity)
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(null);
        byte[] macAddress = networkInterface.getHardwareAddress();
        StringBuilder fingerprint = new StringBuilder();
        for (byte b : macAddress) {
            fingerprint.append(String.format("%02X", b));
        }
        return fingerprint.toString();
    }

    private String loadLicenseKey() {
        // Simulate loading an encrypted license key
        // For demonstration, assume the key is hardcoded
        return "your_encrypted_license_key_here";
    }

    private String decryptLicenseKey(String encryptedLicenseKey) throws NoSuchAlgorithmException, InvalidKeyException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        // Decrypt license key using secret key
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedLicenseKey.getBytes(StandardCharsets.UTF_8));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        LicenseVerifier verifier = new LicenseVerifier();
        boolean isVerified = verifier.verifyLicense();
        System.out.println("License Verification: " + isVerified);
    }
}