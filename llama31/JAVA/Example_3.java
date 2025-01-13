import com.sun.jna.Library;
import com.sun.jna.Native;

public interface ExampleLib extends Library {
    void printHello();
}

public class Example_3_3 {
    public static void main(String[] args) {
        ExampleLib lib = Native.loadLibrary("example", ExampleLib.class);
        lib.printHello();
    }
}