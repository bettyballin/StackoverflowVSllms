import java.lang.String;
import java.io.File;
import java.io.IOException;

public class OpenFileWithDefaultEditor_1 {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.csv");
        try {
            Runtime.getRuntime().exec(new String[] {"xdg-open", file.getAbsolutePath()});
        } catch (IOException e) {
            // handle exception
        }
    }
}