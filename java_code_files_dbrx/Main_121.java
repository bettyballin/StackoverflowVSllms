import javax.crypto.*;
import java.math.BigInteger;
import java.security.KeyGenerator;

public class Main {
    public static void main(String[] args) throws Exception {
        // Initialize secret key for encryption and decryption.
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // For simplicity use same random number each time but better practice is to have a unique secret per application instance.
        SecretKey secretKey = keyGen.generateKey();
        Cipher cipherEncrypt = Cipher.getInstance("AES/ECB/NoPadding");
        cipherEncrypt.init(Cipher.ENCRYPT_MODE, secretKey);
        // Example order id (you will have your real input number instead).
        BigInteger[] bigInts = {BigInteger.valueOf(1), BigInteger.valueOf(2)};
        for (BigInteger bi : bigInts) {
            byte[] bytesToEncrypt = padWithNullBytesAsNecessary(bi, 8); // Ensure 8 digits always
            byte[] encryptedText = cipherEncrypt.doFinal(bytesToEncrypt);
            System.out.println("Encrypted order number: " + new BigInteger(encryptedText).toString());
        }
    }

    private static final byte PADDING_BYTE = 0; // Null bytes used for padding null bytes.

    /**
     * This function makes sure that the actualOrderNumber is at least of length 8
     * (max length we can have in result due to our requirement).
     */
    private static byte[] padWithNullBytesAsNecessary(BigInteger bi, int numDigits) {
        int paddingZeros = numDigits - bi.toString().length();
        String s;
        if (paddingZeros > 0) {
            s = new BigInteger("10").pow(paddingZeros).multiply(bi).toString();
        } else {
            s = bi.toString();
        }
        return paddedToBytes(s); // Convert string of numbers into byte array (each digit as a separate byte here) ready for encryption via Cipher.doFinal call.
    }

    private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' }; // Allowed digits for the resultant obfuscated order numbers as per problem requirement.

    /**
     * This function converts string (of length >= 8) into a byte array of same size.
     * Each character is converted to its ASCII equivalent and set as in byte[].
     */
    private static byte[] paddedToBytes(String s) {
        char[] chars = s.toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (byte) chars[i];
        }
        return bytes; // Conversion from string to bytes.
    }
}