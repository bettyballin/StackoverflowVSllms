import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWithCleanup {
    public static void main(String[] args) {
        FileWriter file = null;
        try {
            file = new FileWriter("example.txt");
            // Write to the file here...
            file.write("Hello, World!");
        } catch (Exception e) {
            // Handle exceptions here...
            e.printStackTrace();
        } finally {
            try {
                if(file != null) {
                    file.close();
                }
            } catch (IOException ex) {
                // Handle additional exceptions from closing the file...
                ex.printStackTrace();
            }
        }
    }
}