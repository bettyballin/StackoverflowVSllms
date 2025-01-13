import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.nio.charset.StandardCharsets;

public class Main_125 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        // Define the data and key
        String data = "your_data_here";
        String key = "your_secret_key_here";

        // Create a SecretKeySpec object
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

        // Create a Mac object
        Mac macInstance = Mac.getInstance("HmacSHA256");

        // Initialize the Mac object with the SecretKeySpec
        macInstance.init(secretKeySpec);

        // Update the Mac object with the data bytes
        macInstance.update(data.getBytes(StandardCharsets.UTF_8));

        // Get the HMAC-SHA256 digest
        byte[] digest = macInstance.doFinal();

        // Convert the digest to a hexadecimal string
        StringBuilder hexDigest = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexDigest.append('0');
            }
            hexDigest.append(hex);
        }

        // Output the result
        System.out.println(hexDigest.toString());
    }
}