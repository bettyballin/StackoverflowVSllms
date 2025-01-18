import java.lang.String;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamCloser {
    public static void main(String[] args) {
        FileInputStream input = null;
        String inputFilePath = "input.txt"; // Define the inputFilePath
        try{
            input = new FileInputStream(inputFilePath);
            // Code using the stream here
        } catch (IOException e){
            // Handle exception
        } finally {
            if(input != null) {
                try {
                    input.close(); // Close resources in a finally block to allow GC do its job.
                } catch (IOException e) {
                    // Handle exception
                }
            }
        }
    }
}