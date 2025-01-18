import java.io.*;
import java.util.zip.*;

public class FileSplitter {
    private static final int BUFFER_SIZE = 1024 * 1024; // Set buffer size as per requirement (e.g., 1MB here)
    private static final String BASE_FILENAME = "large-file";
    private static final long MAX_FILE_SIZE = 3L * 1024 * 1024 * 1024; // Set max file size limit (e.g., 3GB here)
    public static void main(String args[]) throws IOException {
        String inputFilePath = "path\\to\\your-large-file";
        splitFiles(inputFilePath);
    }

    private static void splitFiles(String filePath) throws IOException {
        FileInputStream sourceFileIS = new FileInputStream(filePath);
        try (BufferedInputStream reader = new BufferedInputStream(sourceFileIS)) {
            ZipOutputStream zos = null;
            byte[] buffer = new byte[BUFFER_SIZE];
            int partCounter = 1;
            int bytesReadLastPart = 0;
            File file = null;
            while (true) {
                int bytesRead = reader.read(buffer, 0, BUFFER_SIZE);
                if (bytesRead == -1) {
                    // End of input stream reached
                    if (zos != null) {
                        zos.closeEntry();
                        zos.close();
                    }
                    break;
                }
                if (file == null || file.length() >= MAX_FILE_SIZE) {
                    // Need to create a new split file
                    if (zos != null) {
                        zos.closeEntry();
                        zos.close();
                    }
                    file = new File(BASE_FILENAME + "-part" + String.format("%02d", partCounter++) + ".zip");
                    zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    // Create a zip entry for current split file
                    ZipEntry entry = new ZipEntry(BASE_FILENAME + "-part" + String.format("%02d", partCounter - 1));
                    zos.putNextEntry(entry);
                }
                if (file.length() + bytesRead > MAX_FILE_SIZE) {
                    // Split the buffer to fit in current file
                    int diff = (int) (MAX_FILE_SIZE - file.length());
                    zos.write(buffer, 0, diff);
                    // Prepare remaining bytes for next file
                    System.arraycopy(buffer, diff, buffer, 0, bytesRead - diff);
                    int remainingBytes = bytesRead - diff;
                    // Close current file
                    zos.closeEntry();
                    zos.close();
                    // Start new file
                    file = new File(BASE_FILENAME + "-part" + String.format("%02d", partCounter++) + ".zip");
                    zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                    // Create a new zip entry
                    entry = new ZipEntry(BASE_FILENAME + "-part" + String.format("%02d", partCounter - 1));
                    zos.putNextEntry(entry);
                    // Write remaining bytes to new file
                    zos.write(buffer, 0, remainingBytes);
                } else {
                    zos.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}