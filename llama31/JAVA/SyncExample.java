import java.lang.String;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SyncExample {
    public static void main(String[] args) throws IOException {
        File file = new File("example.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            // Write data to file...
            fos.getFD().sync(); // Force sync
        }
    }
}