import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class ZipExample {
    public static void main(String[] args) throws IOException {
        // Set the password
        String password = "mysecretpassword";

        // Create a ZIP archive
        try (ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(new FileOutputStream("example.zip"))) {
            zipOut.setMethod(ZipArchiveOutputStream.DEFLATED);

            // Add a file to the ZIP archive with password protection
            File file = new File("example.txt");
            ZipArchiveEntry entry = new ZipArchiveEntry(file.getName());
            entry.setSize(file.length());
            entry.setMethod(ZipArchiveEntry.DEFLATED);
            entry.setEncrypted(true);
            entry.setPassword(password.toCharArray());
            zipOut.putArchiveEntry(entry);
            IOUtils.copy(new FileInputStream(file), zipOut);
            zipOut.closeArchiveEntry();
        }
    }
}