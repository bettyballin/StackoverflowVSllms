import java.lang.String;
import java.io.File;

public class YourClass_1 {
    static {
        final String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // Set the path to the DLL, assuming it's in the same directory as the jar file.
            String dllPath = new File(System.getProperty("user.dir"), "someDLLFile.dll").getAbsolutePath();
            System.load(dllPath);
        } else {
            throw new java.lang.UnsatisfiedLinkError("Unsupported operating system");
        }
    }

    // Your JNI methods here

    public static void main(String[] args) {
    }
}