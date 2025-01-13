import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class LicenseValidator {
    private static final String LICENSE_KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public static boolean validateLicenseKey(String licenseKey, PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(licenseKey.getBytes());
            return signature.verify(getSignature(licenseKey, getPrivateKey()));
        } catch (Exception e) {
            return false;
        }
    }

    private static PrivateKey getPrivateKey() {
        try {
            // Load or generate the private key
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(LICENSE_KEY_ALGORITHM);
            kpg.initialize(2048); // key size
            KeyPair keyPair = kpg.generateKeyPair();
            return keyPair.getPrivate();
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] getSignature(String licenseKey, PrivateKey privateKey) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateKey);
            signature.update(licenseKey.getBytes());
            return signature.sign();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        // Generate a key pair for testing
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(LICENSE_KEY_ALGORITHM);
        kpg.initialize(2048); // key size
        KeyPair keyPair = kpg.generateKeyPair();

        String licenseKey = "example_license_key";
        PublicKey publicKey = keyPair.getPublic();
        boolean isValid = validateLicenseKey(licenseKey, publicKey);
        System.out.println("License key is valid: " + isValid);
    }
}