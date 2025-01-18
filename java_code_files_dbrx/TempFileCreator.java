import java.lang.String;
import java.io.File;
import java.io.IOException;

public class TempFileCreator {
    static {
        try {
            File temp = File.createTempFile("MyApp_", null);
            //use temp file here
        } catch (IOException ex) {
            System.err.println("Unable to create temporary file!");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}