import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadingExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("path_to_your_file.txt");
        FileInputStream fis = new FileInputStream(file);

        while (true) {
            byte[] buffer = new byte[1024];
            int bytesRead = fis.read(buffer);

            if (bytesRead == -1) {
                // Handle EOF: sleep for a short period of time and continue reading
                Thread.sleep(100);
                continue;
            }

            // Process the read data
            String data = new String(buffer, 0, bytesRead);
            System.out.println(data);
        }
    }
}