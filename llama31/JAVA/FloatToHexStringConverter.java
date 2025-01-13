import java.lang.String;

public class FloatToHexStringConverter {
    public static void main(String[] args) {
        float f = -3.14f; // example float value
        String hex = (f < 0 ? "-" : "") + String.format("%08x", Float.floatToRawIntBits(Math.abs(f)));
        System.out.println(hex);
    }
}