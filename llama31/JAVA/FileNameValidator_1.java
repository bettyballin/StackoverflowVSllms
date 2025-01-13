import java.io.File;
import java.io.IOException;

public class FileNameValidator_1_1 {
    public boolean OKtoRename(String oldName, String newName) {
        try {
            new File(newName).getCanonicalPath();
            // if no exception is thrown, the file name is valid
            // you can proceed with your existing logic here
            return true; // added return statement
        } catch (IOException e) {
            // if an exception is thrown, the file name is invalid
            return false;
        }
    }

    public static void main(String[] args) {
        FileNameValidator_1 validator = new FileNameValidator_1();
        System.out.println(validator.OKtoRename("oldName", "newName"));
    }
}