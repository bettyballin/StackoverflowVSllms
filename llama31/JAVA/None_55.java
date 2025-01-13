import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class None_55_55 {
    public static int OpenForRead(String file_name) {
        int file_handle = -1;
        File file = new File(file_name);
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                file_handle = reader.hashCode(); // Note: This is not a real file handle, but just a hash code
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
        return file_handle;
    }

    public static void main(String[] args) {
        System.out.println(OpenForRead("example.txt"));
    }
}