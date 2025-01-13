import java.io.File;

public class NativeLibraryLoader {
    public static void loadLibrary(String libName) {
        String libPath = System.getProperty("user.dir") + File.separator + libName + ".dll";
        System.load(libPath);
    }

    public static void main(String[] args) {
    }
}