import java.lang.String;
import java.util.Base64;

public class Base64UuidCodec {
    byte[] uuidArr = new byte[16]; // Initialize uuidArr with zeros

    String encodedUUID = Base64.getEncoder().encodeToString(uuidArr); // Encode UUID to Base64 string
    byte[] decodedBytes = Base64.getDecoder().decode(encodedUUID);     // Decode Base64 string back into bytes

    public static void main(String[] args) {
    }
}