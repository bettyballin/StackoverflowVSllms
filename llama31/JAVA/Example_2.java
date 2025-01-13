import java.lang.String;

public class Example_2_2 {
    public native void printHello();

    static {
        System.loadLibrary("example");
    }

    public static void main(String[] args) {
        new Example_2().printHello(); // Changed from Example to Example_2
    }
}