import java.lang.String;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GzipDecompressor {
    public static void decompressGzipFile(String inputFile, String outputFile) throws IOException {
        try (GzipCompressorInputStream in = new GzipCompressorInputStream(new FileInputStream(inputFile));
             FileOutputStream out = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "path/to/your/gzip/file.gz";
        String outputFile = "path/to/your/decompressed/file";

        decompressGzipFile(inputFile, outputFile);
    }
}