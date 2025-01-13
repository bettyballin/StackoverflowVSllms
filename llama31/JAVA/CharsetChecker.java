import java.lang.String;
import java.nio.charset.Charset;

public class CharsetChecker {
    public static void main(String[] args) {
        String str = "Hello, World!";
        Charset charset = Charset.forName("UTF-8");
        if (charset.newEncoder().canEncode(str)) {
            System.out.println("String is UTF-8 encoded.");
        } else {
            System.out.println("String is not UTF-8 encoded.");
        }
    }
}