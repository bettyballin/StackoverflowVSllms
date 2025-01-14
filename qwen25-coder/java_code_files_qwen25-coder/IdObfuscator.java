import java.lang.String;
import java.lang.Integer;
import java.util.Base64;

public class IdObfuscator {
    public static String encodeId(int id) {
        byte[] encodedBytes = Base64.getEncoder().encode(Integer.toString(id).getBytes());
        return new String(encodedBytes);
    }

    public static int decodeId(String encodedId) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedId);
        return Integer.parseInt(new String(decodedBytes));
    }

	public static void main(String[] args) {
	}
}