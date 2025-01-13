import java.lang.String;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Main_690 {
    public static void main(String[] args) {
        String s = "Happy &amp; Sad";
        System.out.println(s);

        String decoded = URLDecoder.decode(s, StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}