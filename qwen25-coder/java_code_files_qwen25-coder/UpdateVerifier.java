import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;

public class UpdateVerifier {

    public static boolean verifyUpdate(FileInputStream fileInputStream, PublicKey publicKey, byte[] signatureBytes) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        DigestInputStream dis = new DigestInputStream(fileInputStream, sha256);
        while (dis.read() >= 0); // Read through the file to compute SHA-256 hash
        byte[] digest = sha256.digest();

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(digest);

        return signature.verify(signatureBytes);
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("path/to/update/file.jar");
        // Assume publicKey and signatureBytes are obtained securely
        PublicKey publicKey = null; // obtain the actual public key
        byte[] signatureBytes = null; // obtain the actual signature bytes

        if (verifyUpdate(fileInputStream, publicKey, signatureBytes)) {
            System.out.println("Update verified successfully!");
        } else {
            System.out.println("Verification failed: Possible tampering detected.");
        }
    }
}