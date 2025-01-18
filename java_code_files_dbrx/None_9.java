import java.lang.String;
import java.util.Base64;

public class None_9 {
    byte[] header;
    String base64 = Base64.getEncoder().encodeToString(header);  //Result: "/w=="

    public static void main(String[] args) {
    }
}