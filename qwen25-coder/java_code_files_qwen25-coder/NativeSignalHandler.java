import java.lang.String;
// This is a conceptual example using JNI to handle signals,
// but note that handling specific signals like SIGINT is usually better done with shutdown hooks.
public class NativeSignalHandler {
    static {
        System.loadLibrary("signal_handler"); // Load native library
    }

    public native void registerNativeSignalHandler();

    public static void main(String[] args) {
        new NativeSignalHandler().registerNativeSignalHandler();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}