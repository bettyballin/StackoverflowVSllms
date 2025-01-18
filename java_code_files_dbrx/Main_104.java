import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        String json = "[\"My Data\"]";
        String escapedData = URLEncoder.encode(json, StandardCharsets.UTF_8.name());

        String html = "<html><body><script>var <Your JavaScript Variable Name> = '';</script></body></html>";
        html = html.replace("<Your JavaScript Variable Name>", escapedData);

        System.out.println(html);
    }
}