// Example of compressing JSON using Brotli in Java (requires the brotli library)
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.brotli.wrapper.enc.BrotliOutputStream;

public class BrotliCompressionExample {

    public static byte[] brotliCompress(String str) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (BrotliOutputStream brotliStream = new BrotliOutputStream(output)) {
            brotliStream.write(str.getBytes(StandardCharsets.UTF_8));
        }
        return output.toByteArray();
    }
}