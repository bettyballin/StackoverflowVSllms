import java.lang.String;
import java.io.File;
import java.io.FileReader;

public class FileTest {
    public static void main(String[] args) {
        String filePath = "\\\\remote-machine\\dir\\MyFileHere.txt";
        File file = new File(filePath);
        try (FileReader fr = new FileReader(file)) {
            System.out.println("File is accessible.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}