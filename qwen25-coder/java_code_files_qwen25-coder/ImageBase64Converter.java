import java.lang.String;
import java.util.Base64;

public class ImageBase64Converter {
    public static String convertByteArrayToBase64(byte[] imageBytes) {
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
    }

	public static void main(String[] args) {
	}
}