import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SignatureGenerator {
    public static String generateSignature(String secretKey, String requestMethod, String requestPath, String requestBody) throws Exception {
        String dataToSign = requestMethod + "\n" + requestPath + "\n" + requestBody;
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);
        byte[] signatureBytes = mac.doFinal(dataToSign.getBytes());
        return bytesToHex(signatureBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String secretKey = "your_secret_key";
        String requestMethod = "GET";
        String requestPath = "/path/to/resource";
        String requestBody = "{\"key\":\"value\"}";
        String signature = generateSignature(secretKey, requestMethod, requestPath, requestBody);
        System.out.println("Generated Signature: " + signature);
    }
}