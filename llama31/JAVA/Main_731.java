import org.brotli.Brotli;
import org.brotli.BrotliCompressor;

public class Main_731 {
    public static void main(String[] args) {
        // Assuming jsonBytes is a byte array containing JSON data
        byte[] jsonBytes = "{\"key\":\"value\"}".getBytes();

        BrotliCompressor compressor = new BrotliCompressor();
        byte[] compressedBytes = compressor.compress(jsonBytes);
        
        // Print the compressed bytes
        for (byte b : compressedBytes) {
            System.out.print(b + " ");
        }
    }
}