import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.X509Certificate;

public class CertificateVerifier_1_1 {
    public static void main(String[] args) throws Exception {
        // Load the root CA certificate
        X509Certificate rootCaCert = loadRootCaCert();

        // Get the server's certificate
        X509Certificate serverCert = getServerCert();

        // Extract the signature from the server's certificate
        byte[] signature = serverCert.getSignature();

        // Verify the signature using the root CA's public key
        PublicKey rootCaPubKey = rootCaCert.getPublicKey();
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(rootCaPubKey);
        sig.update(serverCert.getEncoded());
        boolean isValid = sig.verify(signature);

        if (isValid) {
            System.out.println("Signature is valid, public key is trusted.");
        } else {
            System.out.println("Signature is invalid, public key is not trusted.");
        }
    }

    // Assuming these methods are implemented elsewhere in your code
    private static X509Certificate loadRootCaCert() {
        // Implementation to load the root CA certificate
        return null;
    }

    private static X509Certificate getServerCert() {
        // Implementation to get the server's certificate
        return null;
    }
}