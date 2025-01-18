import java.io.*;
import org.apache.commons.io.IOUtils;

public class FileDownloader_1 {

    public void getDownload(OutputStream output) throws UtilException {
        try (FileInputStream input = new FileInputStream("path/to/your/pdf")) { // replace with the actual path to your PDF file
            IOUtils.copy(input, output);
            output.flush();
        } catch (IOException e) {
            throw new UtilException("Could not get download: " + e.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    // Ignore
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}

// Definition of UtilException
class UtilException extends Exception {
    public UtilException(String message) {
        super(message);
    }
}