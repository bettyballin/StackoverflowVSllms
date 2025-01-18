import java.nio.file.Paths;
import java.nio.file.Path;

public class Main {
    public boolean OKtoRename(String oldName, String newName) {
        try {
            Path test = Paths.get(newName); // will throw an exception if the syntax of 'newName' is incorrect
            return true; // path is valid
        } catch (Exception e) {
            return false; // path is invalid
        }
    }
}