import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Sha1HashEncoder {
    StringBuilder sb = new StringBuilder();
    byte[] sha1HashBytes; // assume this contains your SHA-1 hash bytes.

    {
        for (byte b : sha1HashBytes) {
            int v = (b & 0xff);
            String hv = Integer.toHexString(v).toUpperCase();
            if (hv.length() < 2)
                sb.append("0");
            sb.append(hv);
        }
        // SHA-1 hash as hex string representation, with "hex" prefix to indicate its format.
        sb.insert(0, "hex");
        String sha1UrlEncoded = URLEncoder.encode(sb.toString(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
    }
}