/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class LicenseValidator {
    private static final String LICENSE_KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public static boolean validateLicenseKey(String string, PublicKey publicKey) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(string.getBytes());
            return signature.verify(LicenseValidator.getSignature(string, LicenseValidator.getPrivateKey()));
        }
        catch (Exception exception) {
            return false;
        }
    }

    private static PrivateKey getPrivateKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(LICENSE_KEY_ALGORITHM);
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair.getPrivate();
        }
        catch (Exception exception) {
            return null;
        }
    }

    private static byte[] getSignature(String string, PrivateKey privateKey) {
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateKey);
            signature.update(string.getBytes());
            return signature.sign();
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(LICENSE_KEY_ALGORITHM);
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        String string = "example_license_key";
        PublicKey publicKey = keyPair.getPublic();
        boolean bl = LicenseValidator.validateLicenseKey(string, publicKey);
        System.out.println("License key is valid: " + bl);
    }
}
