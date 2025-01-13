import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) {
        File file = new File("example.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            // write to file
        } catch (IOException e) {
            // handle exception
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // handle exception
                }
            }
        }
    }
}