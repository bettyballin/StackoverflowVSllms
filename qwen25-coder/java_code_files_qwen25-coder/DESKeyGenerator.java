import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class DESKeyGenerator {
    public static byte[] generateDESKey(char[] passphrase) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(passphrase, new byte[8], 65536, 56); // Adjust salt and iteration count
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();

        // Ensure the parity bits are set correctly for DES
        for (int i = 0; i < keyBytes.length; i++) {
            int p = Integer.bitCount(keyBytes[i] & 0xFF) % 2;
            if (p == 0) keyBytes[i] ^= 1; // Set the least significant bit to 1 if necessary
        }

        return Arrays.copyOfRange(keyBytes, 0, 8); // DES keys are 8 bytes with parity bits
    }

    public static void main(String[] args) {
        try {
            byte[] desKey = generateDESKey("myPassphrase".toCharArray());
            System.out.println(Arrays.toString(desKey));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}