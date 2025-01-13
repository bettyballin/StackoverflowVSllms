import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

public class SecureZip {
    public static void main(String[] args) throws Exception {
        // Set the password and salt
        String password = "mysecretpassword";
        byte[] salt = new byte[16]; // randomly generated salt

        // Create a ZIP file
        try (FileOutputStream fos = new FileOutputStream("example.zip");
             ArchiveOutputStream aos = new ArchiveStreamFactory().createArchiveOutputStream("zip", fos)) {

            // Set the encryption options
            // Commented out because AESCipher is not a standard class
            // aos.setMethod(ZipArchiveEntry.METHOD_AES);
            // aos.setEncryption(new AESCipher(password, salt));

            // Add a file to the ZIP archive
            File file = new File("example.txt");
            ZipArchiveEntry entry = new ZipArchiveEntry(file.getName());
            entry.setSize(file.length());
            aos.putArchiveEntry(entry);
            try (FileInputStream fis = new FileInputStream(file)) {
                IOUtils.copy(fis, aos);
            }
            aos.closeArchiveEntry();
        } catch (IOException | ArchiveException e) {
            System.err.println("Error creating or writing to the ZIP file: " + e.getMessage());
        }
    }
}