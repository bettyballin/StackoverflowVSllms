import org.opencv.core.Core;
public class OpenCVLoader {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public static void main(String[] args) {
    }
}