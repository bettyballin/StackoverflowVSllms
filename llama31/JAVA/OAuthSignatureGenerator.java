import java.lang.String;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class OAuthSignatureGenerator {
    public static String generateSignature(String method, String url, String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, String... params) throws Exception {
        // Sort and concatenate request parameters
        String concatenatedParams = getConcatenatedParams(params);

        // Create the base string
        String baseString = method + "&" + URLEncoder.encode(url, "UTF-8") + "&" + URLEncoder.encode(concatenatedParams, "UTF-8");

        // Generate the signing key
        String signingKey = consumerSecret + "&" + (accessTokenSecret != null ? accessTokenSecret : "");

        // Calculate the signature
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKeySpec = new SecretKeySpec(signingKey.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
        mac.init(secretKeySpec);
        byte[] signatureBytes = mac.doFinal(baseString.getBytes(StandardCharsets.UTF_8));

        // Base64-encode the signature
        String signature = Base64.getEncoder().encodeToString(signatureBytes);

        return signature;
    }

    private static String getConcatenatedParams(String... params) {
        // Sort and concatenate request parameters
        StringBuilder concatenatedParams = new StringBuilder();
        for (String param : params) {
            if (concatenatedParams.length() > 0) {
                concatenatedParams.append("&");
            }
            concatenatedParams.append(param);
        }
        return concatenatedParams.toString();
    }

	public static void main(String[] args) {
	}
}