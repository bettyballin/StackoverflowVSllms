import java.lang.String;
public class MyNativeLib {
    static {
        System.loadLibrary("mylib"); // Load the shared library using its name (without lib or .dll/.so)
    }

    public native void myNativeMethod();

	public static void main(String[] args) {
	}
}