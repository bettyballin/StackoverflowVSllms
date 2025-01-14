import java.lang.String;
import java.security.PublicKey;

public class CertificateVerifier {
    boolean verifySignature(Certificate serverCertificate, PublicKey rootCAPublicKey) {
        // Extract the signature and data from the certificate
        byte[] signature = serverCertificate.getSignature();
        byte[] data = serverCertificate.getData();

        // Use the Root CA's public key to verify the signature
        return CryptoLibrary.verifySignature(data, signature, rootCAPublicKey);
    }

    public static void main(String[] args) {
    }
}

// Dummy Certificate interface
interface Certificate {
    byte[] getSignature();
    byte[] getData();
}

// Dummy CryptoLibrary class
class CryptoLibrary {
    public static boolean verifySignature(byte[] data, byte[] signature, PublicKey publicKey) {
        // Implementation would verify signature using public key
        return true; // Placeholder
    }
}