import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AESUtils {
    private static final String salt = "SomeRandomSalt"; // This should be a strong and unique value for each key!

    public static void main(String[] args) throws Exception {
        char[] passphrase = "ThisIsYourSecretPassword".toCharArray();
        byte[] derivedKey = deriveKey(passphrase, salt.getBytes());
        SecretKey secretKey = new SecretKeySpec(derivedKey, 0 , derivedKey.length, "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // Or any other suitable mode you want to use
        IvParameterSpec ivParamSpe = new IvParameterSpec(salt.getBytes());  // Initialization vector needs to be the same when encrypting and decrypting! Use random value for each encryption, store it along with ciphertext (or derive it from password)!
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParamSpe);
    }

    private static byte[] deriveKey(char[] passphraseOrPin, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec keySpec = new PBEKeySpec(passphraseOrPin, salt, 65536, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWITHSHAANDTWOFISH_CBC");
        return secretKeyFactory.generateSecret(keySpec).getEncoded();
    }
}