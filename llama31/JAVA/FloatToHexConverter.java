import java.lang.String;

public class FloatToHexConverter {
    public static void main(String[] args) {
        float f = 1.0f; // define a float value
        String hex = String.format("%08x", Float.floatToRawIntBits(f));
        System.out.println(hex); // print the result
    }
}