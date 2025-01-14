import java.lang.String;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTypeChecker {

    public static String checkFileType(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (FileChannel fileChannel = FileChannel.open(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(8); // Allocate buffer for 8 bytes
            int bytesRead = fileChannel.read(buffer);

            if (bytesRead < 8) {
                throw new IOException("Not enough bytes to read the magic number");
            }

            buffer.flip(); // Prepare buffer for reading

            byte[] header = new byte[8];
            buffer.get(header, 0, 8); // Extract the first 8 bytes

            // Check for ZIP/JAR magic numbers
            if ((header[0] & 0xFF) == 0x50 && (header[1] & 0xFF) == 0x4B && (header[2] & 0xFF) == 0x03 && (header[3] & 0xFF) == 0x04) {
                return "ZIP/JAR file";
            }
            // Check for RAR magic number
            else if ((header[0] & 0xFF) == 0x52 && (header[1] & 0xFF) == 0x61 && (header[2] & 0xFF) == 0x72 && (header[3] & 0xFF) == 0x21) {
                return "RAR file";
            }
            // Check for XML magic number
            else if ((header[0] & 0xFF) == 0x3C && (header[1] & 0xFF) == 0x3F && (header[2] & 0xFF) == 0x78 && (header[3] & 0xFF) == 0x6D &&
                     (header[4] & 0xFF) == 0x6C) {
                return "XML file";
            }
            // Check for plain text magic number (not reliable, checking if it's printable ASCII)
            else if (isPrintableAscii(header)) {
                return "Probably a text file";
            } else {
                return "Unknown or binary file";
            }
        }
    }

    private static boolean isPrintableAscii(byte[] data) {
        for (byte b : data) {
            if ((b < 0x20 && b != '\n' && b != '\r' && b != '\t') || b > 0x7E) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            System.out.println(checkFileType("path/to/your/file"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}