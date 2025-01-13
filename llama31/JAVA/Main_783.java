import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_783 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("file.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {
            // use fis and fos
        } catch (IOException e) {
            // handle exception
        }
    }
}