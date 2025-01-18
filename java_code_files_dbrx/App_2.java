import java.lang.String;
public class App_2 {
    static {
        System.loadLibrary("MyNativeMethods");     // Load the library
    }

    public native boolean isAltKeyDown();  // Declare the native function

	public static void main(String[] args) {
	}
}