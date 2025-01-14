import de.schlichtherle.crypto.swing.swing.DefaultPbeParameters;
import de.schlichtherle.truezip.file.TFile;
import de.schlichtherle.truezip.file.TFileOutputStream;
import de.schlichtherle.truezip.fs.FsSyncException;
import de.schlichtherle.truezip.zip.ZipEntry;

import java.io.*;

public class PasswordProtectedZip {
    public static void main(String[] args) throws IOException {
        // Define the source file and the output zip file
        File input = new File("example.txt");
        TFile zipFile = new TFile("password-protected.zip");

        // Password for encryption
        char[] password = "your-password".toCharArray();

        // Set up the parameters for password protection
        DefaultPbeParameters params = new DefaultPbeParameters();
        params.setPassword(password);
        params.setCipherAlgorithm("PBEWithMD5AndDES");
        params.setCompression(ZipEntry.DEFLATED);

        // Create the ZIP file
        TFile archiveEntry = new TFile(zipFile, input.getName());

        try (InputStream in = new FileInputStream(input);
             OutputStream out = new TFileOutputStream(archiveEntry, params)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } finally {
            try {
                TFile.umount();
            } catch (FsSyncException e) {
                e.printStackTrace();
            }
        }
    }
}