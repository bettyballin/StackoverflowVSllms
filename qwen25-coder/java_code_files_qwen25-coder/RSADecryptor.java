import java.lang.String;
import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;
import java.security.spec.X509EncodedKeySpec;

public class RSADecryptor {
    public static void main(String[] args) throws Exception {
        String publicKeyPEM = "your.pem.key.here"; // received from iOS app after conversion to PEM

        publicKeyPEM = publicKeyPEM.replace("-----BEGIN PUBLIC KEY-----", "");
        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");

        byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pubKey = kf.generatePublic(keySpec);

        // Assuming encryptedData is the data you received from iOS app, encoded in base64
        byte[] encryptedData = Base64.getDecoder().decode("your.encrypted.data.here");

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedData);

        String decryptedText = new String(decryptedBytes);
        System.out.println(decryptedText);
    }
}