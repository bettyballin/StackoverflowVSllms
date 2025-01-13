import java.io.OutputStream;
import java.io.IOException;

public class ExternalProcessExecutor {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("path/to/your/exe");
        Process p = pb.start();
        OutputStream outputStream = p.getOutputStream();
        // Write information to the output stream
        outputStream.write("your_data".getBytes());
        outputStream.close();
    }
}