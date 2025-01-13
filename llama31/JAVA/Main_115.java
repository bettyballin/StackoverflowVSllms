import java.nio.charset.StandardCharsets;

public class Main_115 {
    public static boolean isValidUtf8(String str) {
        try {
            str.getBytes(StandardCharsets.UTF_8);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidUtf8("Hello, World!"));
    }
}