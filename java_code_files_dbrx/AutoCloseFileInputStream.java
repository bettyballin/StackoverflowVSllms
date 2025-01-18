import java.io.FileInputStream;
import java.io.IOException;

public class AutoCloseFileInputStream {
    static String inputFilePath = "inputFile.txt";
    
    static {
        try (FileInputStream input = new FileInputStream(inputFilePath)){
            // Code using the stream here
        } catch (IOException e) {
            // Handle exception
        }
    }
    
    public static void main(String[] args) {
    }
}