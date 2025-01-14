import java.lang.String;
import java.io.File;
import java.net.URL;

public class RelativePathExample {
    public static void main(String[] args) {
        // Using ClassLoader to find a resource relative to the classpath
        URL url = RelativePathExample.class.getClassLoader().getResource("ggla/samples/obj/linux_x86/executable");
        if (url != null) {
            File file = new File(url.getFile());
            System.out.println("File found: " + file.getAbsolutePath());
        } else {
            System.err.println("File not found!");
        }

        // Alternatively, using a relative path from the user.dir system property
        String baseDir = System.getProperty("user.dir");
        File relativeFile = new File(baseDir, "../../../ggla/samples/obj/linux_x86/executable");
        if (relativeFile.exists()) {
            System.out.println("Relative file found: " + relativeFile.getAbsolutePath());
        } else {
            System.err.println("Relative file not found!");
        }
    }
}