import java.lang.String;

public class FileExceptionHandler_1_1 {
    public static void main(String[] args) {
        try {
            // file reading or writing code here
        } catch (Exception e) {
            // handle the exception
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}