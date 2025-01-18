import java.util.Base64;
import java.io.IOException;

public class Base64Encoder_1 {
    public static void main(String[] args) throws IOException {
        String originalText = "text\0moreText";
        byte[] encodedBytes = Base64.getEncoder().encode(originalText.getBytes("UTF-8"));
        System.out.write(encodedBytes);
    }
}