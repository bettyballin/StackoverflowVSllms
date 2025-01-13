import javax.mail.Header;
import javax.mail.internet.InternetHeaders;

public class Main_604 {
    public static void main(String[] args) {
        InternetHeaders headers = new InternetHeaders();
        headers.addHeader("X-Unique-ID", "your-unique-id-here");
    }
}