import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class SignatureVerifier {
    public boolean verifySignature(InputStream data, byte[] signature, byte[] publicKey) throws Exception {
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(publicKey);
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(kf.generatePublic(keySpec));

        BufferedInputStream bis = new BufferedInputStream(data);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            sig.update(buffer, 0, bytesRead);
        }
        bis.close();

        return sig.verify(signature);
    }

    public static void main(String[] args) {
        // Example usage:
        // SignatureVerifier verifier = new SignatureVerifier();
        // InputStream data = ...;
        // byte[] signature = ...;
        // byte[] publicKey = ...;
        // try {
        //     boolean isValid = verifier.verifySignature(data, signature, publicKey);
        //     System.out.println("Signature is valid: " + isValid);
        // } catch (Exception e) {
        //     System.err.println("Error verifying signature: " + e.getMessage());
        // }
    }
}