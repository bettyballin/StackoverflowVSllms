import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapFileReader {
    public static void main(String[] args) {
        String file = "map.mp";
        File f = new File(file);
        if (f.exists()) {
            try {
                // file found, read it
                FileInputStream x = new FileInputStream(f);
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            // file not found
            System.out.println("File not found.");
        }
    }
}