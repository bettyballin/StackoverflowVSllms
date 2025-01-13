import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

// Define a LicenseData class to hold the license data
class LicenseData {
    private String version;
    private int duration;
    private String userName;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Method to convert LicenseData to byte array
    public byte[] toByteArray() {
        String data = version + "," + duration + "," + userName;
        return data.getBytes();
    }
}

public class Main_128 {
    public static void main(String[] args) throws Exception {
        // Generate public/private keypair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();

        // Create license data structure
        LicenseData licenseData = new LicenseData();
        licenseData.setVersion("1.0");
        licenseData.setDuration(365); // days
        licenseData.setUserName("John Doe");

        // Serialize and encrypt license data
        SecretKey encryptionKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
        byte[] encryptedData = cipher.doFinal(licenseData.toByteArray());

        // Generate digital signature
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(encryptedData);
        byte[] signatureBytes = signature.sign();

        // Base64-encode signature and encrypted data
        String licenseKey = Base64.getEncoder().encodeToString(signatureBytes) + "." + Base64.getEncoder().encodeToString(encryptedData);

        System.out.println(licenseKey);
    }
}