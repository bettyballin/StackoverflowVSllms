import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class OracleCompatibleDesEncryption {
    public static void main(String[] args) throws NoSuchPaddingException, 
        InvalidAlgorithmParameterException, InvalidKeyException, NoSuchAlgorithmException, 
        BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {

        String key = "12345678"; // padding if needed up to 8 bytes. Oracle's default behavior is padded with spaces (0x20), but this can be customized.
        byte[] raw = (new DESKeySpec(key.getBytes())).getKey(); // Get actual key material, which could be longer than just the input string if padded.

        Cipher cipher = null;
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");

        try {
            cipher = Cipher.getInstance("DES/ECB/" + getPaddingForCurrentJDKVersion()); // ECB is mandatory and no padding required for Oracle compatibility
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        } catch (InvalidKeyException e) {  // It might throw InvalidKeyException if the given key or password cannot be used to generate a SecretKey instance because it is too short
            raw = new byte[8]; // Fix by padding with zeroes up to 8 bytes
            System.arraycopy(raw, 0, raw, 0, Math.min(key.getBytes().length, raw.length)); // Only override as much key material was provided (if the original input was too short)
        }

        // Now that cipher is initialized, get block size
        final IvParameterSpec zeroIv = new IvParameterSpec(new byte[cipher.getBlockSize()]);

        String data = "InputText";   // Your input string
        byte[] text = cipher.doFinal(data.getBytes());  // Encrypting data
        System.out.println("Encrypted Data :: " + Base64.getEncoder().encodeToString(text));
    }

    public static String getPaddingForCurrentJDKVersion() {
        // Implement logic to determine padding based on JDK version if necessary
        return "NoPadding"; // Assuming NoPadding for compatibility
    }
}