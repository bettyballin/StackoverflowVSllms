import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class DESEncryption {
    public static void main(String[] args) throws Exception {
        // Generate keys and IV (simplified example)

        // Simulate key1 generation
        byte[] keyBytes = new byte[8];
        for (int i = 0; i < 8; i++) {
            keyBytes[i] = (byte) (31 + ((i * Math.sqrt((double) i * 5)) % 100));
        }
        
        // Simulate IV generation
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[8]; // DES block size
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Create the key
        SecretKeySpec desKey = new SecretKeySpec(keyBytes, 0, 8, "DES");

        // Data to encrypt (similar to C++ input)
        byte[] dataToEncrypt = {(byte) 2}; // beginText
        String bufferToEncrypt = "your_string";
        System.arraycopy(bufferToEncrypt.getBytes(), 0, dataToEncrypt, dataToEncrypt.length - 1, bufferToEncrypt.length()); 
        dataToEncrypt[dataToEncrypt.length - 1] = (byte) 3; // endText

        byte[] paddedData = pad(dataToEncrypt);

        // Encryption
        Cipher desCipher;
        desCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey, ivSpec);
        byte[] encryptedBytes = desCipher.doFinal(paddedData);

        // Convert to base64
        String encodedEncryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println(encodedEncryptedString);        
    }

    private static byte[] pad(byte[] data) throws Exception {
        int paddingLength = 8 - (data.length % 8);
        if (paddingLength == 0) {
            paddingLength = 8;
        }
        byte[] paddedData = new byte[data.length + paddingLength];
        System.arraycopy(data, 0, paddedData, 0, data.length);
        for (int i = data.length; i < paddedData.length; i++) {
            paddedData[i] = (byte) paddingLength;
        }
        return paddedData;
    }
}