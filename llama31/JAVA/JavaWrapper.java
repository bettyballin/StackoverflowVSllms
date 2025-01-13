import java.lang.String;
public class JavaWrapper {
    public native void callJavaMethod();

    static {
        System.loadLibrary("JavaWrapper");
    }

	public static void main(String[] args) {
	}
}