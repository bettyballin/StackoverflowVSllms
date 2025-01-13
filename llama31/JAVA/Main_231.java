import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.TarArchiveEntry;
import java.util.zip.TarArchiveInputStream;

public class Main_231 {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("path/to/archive.tar.gz");
             GZIPInputStream gis = new GZIPInputStream(fis);
             TarArchiveInputStream tis = new TarArchiveInputStream(gis)) {

            TarArchiveEntry entry;
            while ((entry = tis.getNextEntry()) != null) {
                File outputFile = new File("path/to/output/directory", entry.getName());
                outputFile.getParentFile().mkdirs(); // Create parent directories if needed
                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = tis.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}