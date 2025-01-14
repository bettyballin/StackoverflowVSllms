import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Base64;

public class QueryStringEncryptor {

    private static final int GCM_TAG_LENGTH = 128; // in bits
    private static final int IV_LENGTH = 12; // in bytes

    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // for example, uses 256-bit AES key
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String dataToEncrypt, long expiryTimeMillis) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecureRandom random = new SecureRandom();

            byte[] iv = new byte[IV_LENGTH];
            random.nextBytes(iv);

            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);

            // Prepares the data to be encrypted: expiry time (long 8 bytes) and the actual data
            ByteBuffer byteBuffer = ByteBuffer.allocate(8 + dataToEncrypt.getBytes().length)
                    .putLong(expiryTimeMillis).put(dataToEncrypt.getBytes());
            byte[] dataToSendEncrypted = cipher.doFinal(byteBuffer.array());

            // Combines iv, encrypted content
            return Base64.getEncoder()
                    .encodeToString(concatByteArrays(iv, dataToSendEncrypted));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String encodedCipherTextWithIv) throws InvalidDataException {
        try {
            byte[] decodedCipherTextWithIv = Base64.getDecoder()
                    .decode(encodedCipherTextWithIv);

            // Separate the IV and encrypted data
            ByteBuffer byteBuffer = ByteBuffer.wrap(decodedCipherTextWithIv);
            byte[] iv = new byte[IV_LENGTH];
            byteBuffer.get(iv);
            byte[] cipherTextWithoutIv = new byte[decodedCipherTextWithIv.length - IV_LENGTH];
            byteBuffer.get(cipherTextWithoutIv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);

            byte[] decryptedBytes = cipher.doFinal(cipherTextWithoutIv);

            // Extract the expiry time and check it
            ByteBuffer dataByteBuffer = ByteBuffer.wrap(decryptedBytes);
            long expiryTimeMillis = dataByteBuffer.getLong();

            if (System.currentTimeMillis() > expiryTimeMillis) {
                throw new InvalidDataException("Expiry Time has Passed");
            }

            byte[] dataBytes = new byte[decryptedBytes.length - 8]; // remaining is the original data
            dataByteBuffer.get(dataBytes);
            return new String(dataBytes);

        } catch (javax.crypto.AEADBadTagException e) {
            throw new InvalidDataException("Authentication tag verification failed.");
        } catch (java.security.InvalidAlgorithmParameterException | javax.crypto.BadPaddingException e) {
            throw new InvalidDataException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] concatByteArrays(byte[] one, byte[] two) {
        ByteBuffer buffer = ByteBuffer.allocate(one.length + two.length)
                .put(one).put(two);
        return buffer.array();
    }

    public static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }

	public static void main(String[] args) {
	}
}