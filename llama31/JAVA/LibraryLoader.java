import java.lang.String;

public class LibraryLoader {
    static {
        System.setProperty("java.library.path", "C:/server");
        System.loadLibrary("someDLLFile");
    }

    public static void main(String[] args) {
    }
}