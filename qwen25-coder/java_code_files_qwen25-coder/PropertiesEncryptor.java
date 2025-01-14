import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class PropertiesEncryptor {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public String encryptProperties(Properties props, byte[] publicKeyData) throws Exception {
        // Convert properties to a string and then to bytes
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        props.store(out, null);
        byte[] dataToEncrypt = out.toByteArray();

        // Generate a random AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt the data with AES
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
        byte[] iv = new byte[16]; // Initialization vector for CBC mode
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encryptedData = aesCipher.doFinal(dataToEncrypt);

        // Encrypt the AES key with RSA
        X509EncodedKeySpec keyspec = new X509EncodedKeySpec(publicKeyData);
        KeyFactory kf = KeyFactory.getInstance("RSA", "BC");
        PublicKey pk = kf.generatePublic(keyspec);
        Cipher rsaCipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding", "BC");
        rsaCipher.init(Cipher.ENCRYPT_MODE, pk);
        byte[] encryptedKey = rsaCipher.doFinal(secretKey.getEncoded());

        // Combine the IV, encrypted key, and encrypted data
        ByteArrayOutputStream combinedStream = new ByteArrayOutputStream();
        combinedStream.write(iv);
        combinedStream.write(encryptedKey);
        combinedStream.write(encryptedData);

        return base64EncodeBytes(combinedStream.toByteArray());
    }

    private String base64EncodeBytes(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) {
    }
}