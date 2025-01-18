import java.util.Base64;

public class Base64Decoder {
    public static void main(String[] args) {
        String encodedData = "..."; // your base64 data
        byte[] decodedData = Base64.getDecoder().decode(encodedData);
        // Then you can convert it to String if needed, assuming the original content is UTF-8 text:
        String utf8EncodedData = new String(decodedData, java.nio.charset.StandardCharsets.UTF_8);
        // ...
    }
}