import java.io.IOException;
import java.lang.String;

public class FileExceptionHandler {
    public static void main(String[] args) {
        try {
            // file reading or writing code here
        } catch (IOException e) {
            // handle the exception
            System.err.println("I/O error occurred: " + e.getMessage());
        }
    }
}