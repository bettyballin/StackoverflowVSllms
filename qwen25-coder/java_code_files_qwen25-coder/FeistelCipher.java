import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class FeistelCipher {

    private static final int ROUNDS = 10;
    private static Cipher cipher;

    public FeistelCipher(String password) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "DES");
        cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
    }

    public long encrypt(long input) {
        return feistel(input, true);
    }

    public long decrypt(long input) {
        return feistel(input, false);
    }

    private long feistel(long m, boolean encr) {
        long L1 = (m >> 32) & 0xFFFFFFFFL;
        long R1 = m & 0xFFFFFFFFL;

        for (int i = 0; i < ROUNDS; i++) {
            long feistelFunctionOutput = f(R1);
            if (encr) {
                L1 ^= feistelFunctionOutput;
            } else {
                R1 ^= feistelFunctionOutput;
            }
            long temp = R1;
            R1 = L1;
            L1 = temp;
        }

        // After last round, swap halves
        if (!encr) {
            long temp = R1;
            R1 = L1;
            L1 = temp;
        }

        return ((L1 << 32) | R1);
    }

    private long f(long input) {
        byte[] bytesInput = toBytes(input);
        try {
            byte[] encryptedBytes = cipher.doFinal(bytesInput);
            return toLong(encryptedBytes);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    private static long toLong(byte[] b) {
        long result = 0;
        for (int i = 0; i < b.length; i++) {
            result = (result << 8) + (b[i] & 0xFF);
        }
        return result >> 16; // Reduce to 40-bit
    }

    private static byte[] toBytes(long input) {
        byte[] arr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            arr[i] = (byte)(input & 0xFF);
            input >>= 8;
        }
        return Arrays.copyOfRange(arr, 2, 8); // Take only last 40 bits
    }

    public static void main(String[] args) throws Exception {
        FeistelCipher feistelCipher = new FeistelCipher("mySecurePassword");

        long originalNumber = 123456789012L; // Example number
        long encryptedNumber = feistelCipher.encrypt(originalNumber);
        long decryptedNumber = feistelCipher.decrypt(encryptedNumber);

        System.out.println("Original: " + originalNumber);
        System.out.println("Encrypted: " + encryptedNumber);
        System.out.println("Decrypted: " + decryptedNumber);

        // Ensure encrypted number is a 12-digit number
        if ((encryptedNumber >= 1_000_000_000_000L) || (encryptedNumber < 100_000_000_000L)) {
            System.out.println("Encrypted number is not a 12-digit number.");
        }
    }
}