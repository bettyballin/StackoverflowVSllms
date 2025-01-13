import java.io.ByteArrayOutputStream;
import java.lang.String;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

public class CompressionExample {
    public static void main(String[] args) throws Exception {
        // Create a sample byte array
        byte[] data = "Hello, World!".getBytes();

        // Compress the data using GZIP
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GzipCompressorOutputStream gos = new GzipCompressorOutputStream(bos);
        gos.write(data);
        gos.close();

        // Get the compressed data
        byte[] compressedData = bos.toByteArray();

        System.out.println("Compressed data: " + compressedData.length);
    }
}