import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class FileExceptionHandler_2_2 {
    public static void main(String[] args) {
        try {
            // file reading or writing code here
        } catch (IOException | FileNotFoundException | NoSuchFileException e) {
            // handle the exception
            System.err.println("I/O error occurred: " + e.getMessage());
        }
    }
}