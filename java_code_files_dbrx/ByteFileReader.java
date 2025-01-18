import java.lang.String;
import java.io.*;

public class ByteFileReader {
    // read bytes into buffer until EOF or error occurs, handling potential errors when reading from file accordingly (instances of IOException, for instance).
    public static void main(String[] args) {
        try (InputStream in = new DataInputStream(new FileInputStream("foo.txt"))) {
            byte[] buffer = new byte[1024];
            int numBytes;
            while ((numBytes = in.read(buffer)) != -1) {
                // do stuff with bytes here... (e.g., write to FileOutputStream, convert to hex string and log, etc.)
            }
        } catch (IOException e) {
            // handle exception
            e.printStackTrace();
        }
    }
}