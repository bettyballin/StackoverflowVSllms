import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.MessageDigest;
import java.security.Cipher;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class RSASigner {

    public static void main(String[] args) throws Exception {
        // Generate new key
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048); // Key size
        KeyPair keyPair = kpg.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        String plaintext = "This is the message being signed";

        // Compute signature
        Signature instance = Signature.getInstance("SHA1withRSA");
        instance.initSign(privateKey);
        instance.update((plaintext).getBytes());
        byte[] signature = instance.sign();

        // Compute digest
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        byte[] digest = sha1.digest((plaintext).getBytes());

        // Wrap digest in ASN.1 structure
        byte[] asn1Digest = new byte[15 + digest.length];
        asn1Digest[0] = 0x30; // SEQUENCE
        asn1Digest[1] = (byte) (13 + digest.length); // length
        asn1Digest[2] = 0x06; // OID
        asn1Digest[3] = 0x09; // OID length
        asn1Digest[4] = 0x2a; // OID: 2a864886f70d010107
        asn1Digest[5] = (byte) 0x86;
        asn1Digest[6] = (byte) 0x48;
        asn1Digest[7] = (byte) 0x86;
        asn1Digest[8] = (byte) 0xf7;
        asn1Digest[9] = 0x0d;
        asn1Digest[10] = 0x01;
        asn1Digest[11] = 0x01;
        asn1Digest[12] = 0x05;
        asn1Digest[13] = 0x05; // NULL
        asn1Digest[14] = 0x00; // NULL
        System.arraycopy(digest, 0, asn1Digest, 15, digest.length);

        // Encrypt digest
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] cipherText = cipher.doFinal(asn1Digest);

        // Display results
        System.out.println("Input data: " + plaintext);
        System.out.println("Digest: " + bytes2String(digest));
        System.out.println("Cipher text: " + bytes2String(cipherText));
        System.out.println("Signature: " + bytes2String(signature));
    }

    public static String bytes2String(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}