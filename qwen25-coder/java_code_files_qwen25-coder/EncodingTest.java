import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class EncodingTest {
    @Test
    public void testUtf8Encoding() {
        String input = "👨‍👩‍👧‍👦"; // Family emoji
        byte[] utf8Bytes = input.getBytes(StandardCharsets.UTF_8);
        // Verify that the bytes match UTF-8 encoding
        assertTrue(Arrays.equals(utf8Bytes, StandardCharsets.UTF_8.encode(input).array()));
    }

    public static void main(String[] args) {
    }
}