import java.lang.String;
import java.security.MessageDigest;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.math.BigInteger;
import java.util.Arrays;

public class RSATransformer {
    MessageDigest md;
    KeyFactory kf;
    RSAPrivateKeySpec keyPrivSpec;
    RSAPublicKeySpec keyPubSpec;
    PrivateKey privateKey;
    PublicKey publicKey;
    String password = "password"; // placeholder for the password
    byte[] digest;
    int bits = 40; // desired bit length

    public RSATransformer() throws Exception {
        md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        digest = md.digest();
        kf = KeyFactory.getInstance("RSA");
        keyPrivSpec = new RSAPrivateKeySpec(new BigInteger(1, Arrays.copyOfRange(digest, 0, 5)), BigInteger.valueOf(5)); // use the first 40 bits as a private 'key'
        keyPubSpec = new RSAPublicKeySpec(BigInteger.ONE.shiftLeft(bits - 1).add(BigInteger.valueOf(3)), BigInteger.valueOf(5)); // where "bits" is the bit length of your 'key' and equals to desired 40
        privateKey = kf.generatePrivate(keyPrivSpec);
        publicKey = kf.generatePublic(keyPubSpec);
    }

    public static void main(String[] args) throws Exception {
        RSATransformer transformer = new RSATransformer();
    }
}