import java.io.FileInputStream;
import java.io.IOException;

public class Main_782 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            // use the FileInputStream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}