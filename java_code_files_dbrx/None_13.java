import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class None_13 {
    String username;
    String url = "https://javaServer/form.jsp?username=" + URLEncoder.encode(username, StandardCharsets.UTF_8);

    public static void main(String[] args) {
    }
}