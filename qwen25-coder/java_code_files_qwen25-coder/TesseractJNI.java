import java.lang.String;
public class TesseractJNI {
    // Load the native library at runtime.
    static {
        System.loadLibrary("tesseract_jni");
    }

    // Declare a native method that will be implemented in C++.
    public native String doOCR(byte[] imageData);

    public static void main(String[] args) {
        // Create instance of the class
        TesseractJNI tesseract = new TesseractJNI();

        // Example usage (assuming you somehow have byte array imageData)
        byte[] imageData = loadImageData();  // This should be your logic to get image data in a byte array

        // Perform OCR
        String result = tesseract.doOCR(imageData);
        System.out.println("OCR Result:\n" + result);
    }

    private static byte[] loadImageData() {
        // Your implementation here to load image data into a byte array
        return new byte[0];
    }
}