import java.lang.String;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256 {
    public String calculateHMAC(String data, String key)
            throws Exception {
        Mac sha256MAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256MAC.init(secretKey);

        return bytesToHex(sha256MAC.doFinal(data.getBytes()));
    }
    
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}