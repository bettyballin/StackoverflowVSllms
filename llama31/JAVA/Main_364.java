import java.security.*;
import java.util.Base64;

public class Main_364 {
    public static void main(String[] args) throws Exception {
        // Key derivation (use a secure random secret key)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Initialize with a key size
        SecretKey symmetricKey = keyGen.generateKey();

        // Symmetric encryption (use AES-GCM for secure block cipher mode)
        Cipher symmetricCipher = Cipher.getInstance("AES/GCM/NoPadding");
        symmetricCipher.init(Cipher.ENCRYPT_MODE, symmetricKey);
        byte[] encryptedData = symmetricCipher.doFinal(("namedata" + "hello").getBytes());

        // Asymmetric encryption (use RSA to encrypt the symmetric key)
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048); // Initialize with a key size
        KeyPair keyPair = kpg.generateKeyPair();
        Cipher asymmetricCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        asymmetricCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic()); // Use public key for encryption
        byte[] encryptedSymmetricKey = asymmetricCipher.doFinal(symmetricKey.getEncoded());

        // Code generation (Base64-encode and format)
        String keyCode = Base64.getEncoder().encodeToString(encryptedSymmetricKey) + "-" +
                         Base64.getEncoder().encodeToString(encryptedData);
        System.out.println(keyCode);
    }
}