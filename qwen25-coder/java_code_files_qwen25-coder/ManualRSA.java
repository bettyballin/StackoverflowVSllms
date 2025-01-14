import java.lang.String;
import java.lang.Integer;
import java.security.*;
import javax.crypto.Cipher;

public class ManualRSA {
    public static void main(String[] args) throws Exception {
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        String plaintext = "This is the message being signed";

        // Compute SHA-1 digest
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        byte[] digest = sha1.digest(plaintext.getBytes());

        // ASN.1 encode the hash with SHA1 OID and length
        byte[] encodedDigest = new byte[47];  // Length of an SHA-1 OID + padding
        int offset = 0;

        // PKCS#1 v1.5 padding header for SHA-1
        byte[] sha1OidPrefix = new byte[]{
            0x30, 0x21, 0x30, 0x09, 0x06, 0x05, (byte) 0x2b, 0x0e,
            0x03, 0x02, 0x1a, 0x05, 0x00, 0x04, 0x14
        };
        System.arraycopy(sha1OidPrefix, 0, encodedDigest, offset, sha1OidPrefix.length);
        offset += sha1OidPrefix.length;

        // Copy the digest into the structure
        System.arraycopy(digest, 0, encodedDigest, offset, digest.length);

        // Optionally, perform RSA encryption using a Cipher object with PKCS#1 v1.5 padding
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] signature = cipher.doFinal(encodedDigest);

        System.out.println("Signature: " + bytes2String(signature));
    }

    private static String bytes2String(byte[] bytes) {
        StringBuilder string = new StringBuilder();
        for (byte b : bytes) {
            String hexString = Integer.toHexString(0x00FF & b);
            string.append(hexString.length() == 1 ? "0" + hexString : hexString);
        }
        return string.toString();
    }
}