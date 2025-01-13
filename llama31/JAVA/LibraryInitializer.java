import java.lang.String;

public class LibraryInitializer {
    static {
        NativeLibraryLoader.loadLibrary("someDLLFile");
    }

    public static void main(String[] args) {
    }
}