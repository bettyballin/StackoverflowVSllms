import java.lang.String;
import java.util.Base64;

public class Main_164 {
    public static void main(String[] args) {
        String encodedText = Base64.getEncoder().encodeToString("example text".getBytes());
        System.out.println(encodedText);
    }
}