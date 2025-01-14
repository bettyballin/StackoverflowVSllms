import java.lang.String;
public class FloatToHex {
    public static void main(String[] args) {
        float f = 123.456f; // Example float value
        String hexString = String.format("%08x", Float.floatToRawIntBits(f));
        System.out.println(hexString);
    }
}