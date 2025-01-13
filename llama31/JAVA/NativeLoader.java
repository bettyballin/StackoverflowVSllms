import java.lang.String;

public class NativeLoader {
    static {
        System.load("C:/server/someDLLFile.dll");
    }

    public static void main(String[] args) {
    }
}