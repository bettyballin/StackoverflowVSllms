import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;

public class Encryption {

    public static String encrypt(Properties properties, byte[] publicKeyData) throws Exception {
        // Generate a random symmetric key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 192 and 256 bits may not be available
        SecretKey symmetricKey = keyGen.generateKey();

        // Encrypt the symmetric key with RSA
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyData);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(publicKeySpec);
        Cipher rsaCipher = Cipher.getInstance("RSA/None/OAEPWithSHA1AndMGF1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedSymmetricKey = rsaCipher.doFinal(symmetricKey.getEncoded());

        // Encrypt the properties with the symmetric key
        Cipher symmetricCipher = Cipher.getInstance("AES");
        symmetricCipher.init(Cipher.ENCRYPT_MODE, symmetricKey);
        byte[] propertiesBytes = properties.toString().getBytes();
        byte[] encryptedProperties = symmetricCipher.doFinal(propertiesBytes);

        // Return the encrypted symmetric key and properties
        byte[] result = new byte[encryptedSymmetricKey.length + encryptedProperties.length];
        System.arraycopy(encryptedSymmetricKey, 0, result, 0, encryptedSymmetricKey.length);
        System.arraycopy(encryptedProperties, 0, result, encryptedSymmetricKey.length, encryptedProperties.length);
        return Base64.getEncoder().encodeToString(result);
    }

	public static void main(String[] args) {
	}
}