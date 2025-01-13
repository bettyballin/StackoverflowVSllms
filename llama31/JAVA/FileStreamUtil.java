import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileStreamUtil {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("path_to_your_file");
        BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 1024); // 1MB buffer
    }
}