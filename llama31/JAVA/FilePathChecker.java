import java.io.File;
import java.lang.String;

public class FilePathChecker {
    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        String relativePath = "../../../ggla/samples/obj/linux_x86";
        String absolutePath = currentDir + File.separator + relativePath;

        File file = new File(absolutePath);
        if (file.exists()) {
            System.out.println("File found!");
        } else {
            System.out.println("File not found!");
        }
    }
}