import java.lang.String;
// TesseractNative.java (Java class that uses the JNI wrapper)
public class TesseractNative {
    public native String doOCR(byte[] image);

    static {
        System.loadLibrary("tess_jni");
    }

	public static void main(String[] args) {
	}
}