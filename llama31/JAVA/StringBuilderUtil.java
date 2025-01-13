import java.lang.String;

public class StringBuilderUtil {
    // Decompiled code for a += b
    public static String append(String a, String b) {
        return new StringBuilder(String.valueOf(a)).append(b).toString();
    }

    public static void main(String[] args) {
        // Test the append method
        String a = "Hello";
        String b = " World";
        System.out.println(append(a, b));
    }
}